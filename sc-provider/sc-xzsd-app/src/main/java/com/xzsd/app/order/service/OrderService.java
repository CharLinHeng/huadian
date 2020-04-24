package com.xzsd.app.order.service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.AreaName;
import com.xzsd.app.driver.entity.DriverResponsibleArea;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.*;
import com.xzsd.app.util.RandomCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * APP端-用户订单Service
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private DriverDao driverDao;
    private static final int HASEVA = 5;
    /**
     * app端-用户-查询订单详情
     * @return
     */
    public AppResponse queryOrderDetail(OrderDetail orderDetail){
        //判断订单编号参数
        if(null == orderDetail.getOrderCode() || orderDetail.getOrderCode() == ""){
            return AppResponse.paramError("订单编号为空!");
        }
        //查询订单详情 这里查到的是还没有转化成地址名称的地址编号结果集 [因为无法用一次sql查出省市区名称，所以我分两步来写]
        OrderDetail orderDetailOut = orderDao.queryOrderDetail(orderDetail.getOrderCode());
        //拼接待查询的参数实体类
        DriverResponsibleArea driverResponsibleArea = new DriverResponsibleArea();
        driverResponsibleArea.setCityCode(orderDetailOut.getCityCode());
        driverResponsibleArea.setDistinctCode(orderDetailOut.getDistinctCode());
        driverResponsibleArea.setProvinceCode(orderDetailOut.getProvinceCode());
        //根据 省市区编号 查询 省市区名称
        AreaName areaNameList = driverDao.queryPCD(driverResponsibleArea);
        //将信息传至输出实体类
        OrderDetailOut orderDetailOutFinal = new OrderDetailOut();
        //赋值给输出实体类
        String address = areaNameList.getProvinceName()+areaNameList.getCityName()+areaNameList.getDistinctName()+
                orderDetailOut.getDetailAddress();
        orderDetailOutFinal.setDeliveryAddress(address);
        orderDetailOutFinal.setDeliveryStore(orderDetailOut.getDeliveryStore());
        orderDetailOutFinal.setOrderCode(orderDetailOut.getOrderCode());
        orderDetailOutFinal.setOrderCreateTime(orderDetailOut.getOrderCreateTime());
        orderDetailOutFinal.setOrderGoodsList(orderDetailOut.getOrderGoodsList());
        orderDetailOutFinal.setOrderState(orderDetailOut.getOrderState());
        //判断结果
        if(null != orderDetailOut.getOrderCode()){
            //输出实体类
            return AppResponse.success("查询订单成功!",orderDetailOutFinal);
        }
        return AppResponse.paramError("查询订单为空");
    }
    /**
     * 修改订单状态
     * @param updateOrder
     * @return
     */
    public AppResponse updateOrder(UpdateOrder updateOrder){
        if(null == updateOrder.getOrderCode()){
            return AppResponse.paramError("订单编号为空!");
        }
        if(updateOrder.getOrderState() == 0){
            return AppResponse.paramError("订单状态不能为0!");
        }
        //如果是取消订单状态，那么需要库存加回对应订单编号所对应 商品的数量  这里的功能[待写]

        //获取当前修改人的Id
        updateOrder.setUpdateUser(SecurityUtils.getCurrentUserId());
        //修改
        int result = orderDao.updateOrder(updateOrder);
        if(result > 0){
            return AppResponse.success("更新状态成功!");
        }
        return AppResponse.bizError("修改失败!");
    }

    /**
     * 查询订单列表
     * @param orderListParam
     * @return
     */
    public AppResponse queryUserOrderList(OrderListParam orderListParam){
        //查询当前登入人的编号
        String userAccunt = SecurityUtils.getCurrentUserId();
        //设置当前登入用户编号
        orderListParam.setUserCode(userAccunt);
        //查询
        PageHelper.startPage(orderListParam.getPageNum(),orderListParam.getPageSize());
        List<OrderList>orderLists = orderDao.queryUserOrderList(orderListParam);
        PageInfo<OrderList>orderListPageInfo = new PageInfo<>(orderLists);
        //判断结果
        if(orderLists.size() > 0){
            return AppResponse.success("查询成功!",orderListPageInfo);
        }
        return AppResponse.paramError("查询为空!");
    }

    /**
     * 增加订单商品评价
     * @param orderEva
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrderGoodsEva(OrderEva orderEva){
        //开始处理对象
        if(null == orderEva.getOrderCode()){
            return AppResponse.paramError("订单编号缺失!");
        }
        //为 每件商品评价 生成编号
        orderEva.setUserCode(SecurityUtils.getCurrentUserId());
        for(int i = 0;i < orderEva.getEvaList().size();i++){
            orderEva.getEvaList().get(i).setCommentCode(RandomCode.radmonkey());
            orderEva.getEvaList().get(i).setCreateUser(orderEva.getUserCode());
        }
        //当前用户-新增至商品评价列表
        int result = orderDao.addOrderGoodsEva(orderEva.getEvaList(),orderEva.getOrderCode());
        //更新订单状态为 已评价
        UpdateOrder updateOrder = new UpdateOrder();
        updateOrder.setOrderCode(orderEva.getOrderCode());
        updateOrder.setOrderState(HASEVA);
        updateOrder.setUpdateUser(SecurityUtils.getCurrentUserUsername());
        int updateOrderState = orderDao.updateOrder(updateOrder);
        //更新商品星级
        int updateOrdeerRank = orderDao.updateGoodRank(orderEva.getEvaList());
        //结果
        if(result > 0){
            return AppResponse.success("添加商品评论成功!",result);
        }
        //判断结果
        return AppResponse.bizError("添加商品评论失败!");
    }
    /**
     *  订单新增
     * @param addOrder
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUserOrder(AddOrder addOrder){
        //判断参数是否齐全
        if(null == addOrder.getCartCode() || addOrder.getCartCode() == ""){
            return AppResponse.paramError("购物车编号为空");
        }
        //获取当前登入人的编号
        addOrder.setUserCode(SecurityUtils.getCurrentUserId());
        //将多个购物车编号转成待处理string数组
        List<String>cartCodeList = Arrays.asList(addOrder.getCartCode().split(","));
        String msg = "";
        //生成 随机订单编号
        addOrder.setOrderCode(RandomCode.radmonkey());
        //初始化订单
        int result = orderDao.addUserOrder(addOrder);
        if(result > 0){
            msg = "初始化订单成功!";
            List<String>newCartCodeList = new ArrayList<>();
            //查询购物车中 有没有商品已经下架或者已删除, 返回已经下架的 购物车编号 已下架的商品无法购买
            List<GoodsExpired> goodsOnShelves = orderDao.goodsExpired(cartCodeList);
            if(goodsOnShelves.size() > 0){
                //将CartCodeList去除已过期的商品
                msg = msg + "已经清除已下架的商品"+goodsOnShelves.size()+"个!";
                boolean con;
                //将已经下架的商品 从 购物车中清除
                for(int i = 0; i < cartCodeList.size() ;i++){
                    con = true;
                    for(int j = 0;j < goodsOnShelves.size();j++){
                        if(goodsOnShelves.get(j).getCartCode().equals(cartCodeList.get(i))){
                            con = false;
                        }
                    }
                    if(con == true){
                        //说明是不过期的商品，则保留
                        newCartCodeList.add(cartCodeList.get(i));
                    }
                }
                //此时list中留下来的是没有过期的商品的购物车编号
            }
            //根据 购物车编号 查询待新增的 订单商品列表
            if(newCartCodeList.size() > 0){
                //接下来，判断购物车中 其 每种商品的数量库存 是否 大于等于 购物车中的 每种商品数量 返回的是那些不符合数量的商品编号
                List<GoodBigThanLibs> nonConformingProducts = orderDao.judgementStock(newCartCodeList);
                if(nonConformingProducts.size() > 0){
                    //将那些购物车的数量修改为当前商品库存的库存的最大数量，如果商品数量库存当前为0，购物车对应商品数量也要替换成 0。
                    String updateCodeList = "";
                    int index = 0;
                    String str = ",";
                    //用逗号拼接上面经过过滤的 带插入到订单商品详情的购物车编号
                    for(GoodBigThanLibs goodBigThanLibs:nonConformingProducts){
                        if(index == 0){
                            str = "";
                        }
                        updateCodeList = updateCodeList+goodBigThanLibs.getGoodCode()+str;
                    }
                    //去将购物车每件商品进行判断和更新，如果 某一件类型的商品数量大于商品库存，则  更新商品库存最大值
                    int updateNum = orderDao.updateGoodNum(Arrays.asList(updateCodeList.split(",")));
                    if(updateNum > 0){
                        msg = msg + "已更新部分购物车商品数量!";
                    }
                }
                //生成订单后， 需要10分钟之内进行支付，否则 订单删除，商品库存恢复，
                // 如果支付成功[订单 这里默认支付成功]，那么将纪录添加到顾客表，并且将 订单商品详情增加到对应表
                List<Order> orderList = orderDao.queryOrderList(newCartCodeList);
                for(int i = 0;i < orderList.size();i++){
                    //给每个订单商品详情随机生成订单详情编号
                    orderList.get(i).setOrderGCode(RandomCode.radmonkey());
                    orderList.get(i).setOrderCode(addOrder.getOrderCode());
                }
                //如果 购物车内待购买的商品种类 数量大于0， 那么 将购买的商品种类信息新增到订单详情
                if(orderList.size() > 0){
                    // 还要将 对应的 商品库存 数量减少 指定 购买的商品数量 然后 售出数量 + 对应数量
                    orderDao.updateGoodRelative(orderList);
                    //新增到订单详情表  [这里漏了需要存商品的图片，需要补上]
                    result = orderDao.addOrderList(orderList);
                    //更新订单总价格  而且需要存 门店编号
                    //判断新增到 订单详情列表的 结果
                    if(result > 0){
                        //添加到顾客表 addOrder 和订单编号
                        Customer customer = orderDao.queryCustomerData(addOrder.getUserCode());
                        customer.setCustomerCode(RandomCode.radmonkey());
                        customer.setUserCode(addOrder.getUserCode());
                        customer.setCustomerOrder(addOrder.getOrderCode());
                        result = orderDao.addCustomer(customer);
                        if(result > 0){
                            msg = msg + "新建客户成功!";
                        }
                        //下单成功后，需要清空对应的购物车
                        int empty = orderDao.clearEmpty(cartCodeList);
                        if(empty > 0){
                            msg = msg + "已清空购物车!下单成功!";
                        }
                        return AppResponse.success(msg);
                    }
                }
            }
            //更新订单 删除
            result = orderDao.deleteOrder(addOrder.getOrderCode(),SecurityUtils.getCurrentUserUsername());
            return AppResponse.paramError(msg+"新增订单失败,您购物车内的商品均被抢空或者下架!");
        }
        //判断结果
        return AppResponse.paramError("新增订单失败");
    }
}
