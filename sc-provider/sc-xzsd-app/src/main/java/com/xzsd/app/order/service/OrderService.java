package com.xzsd.app.order.service;
import com.alibaba.fastjson.JSON;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.AreaName;
import com.xzsd.app.driver.entity.DriverResponsibleArea;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.*;
import com.xzsd.app.util.RandomCode;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
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
    /**
     *  订单新增
     * @param addOrder
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addUserOrder(AddOrder addOrder){
        //判断参数是否齐全
        if(null == addOrder.getCartCode() || addOrder.getCartCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"购物车编号为空",null);
        }
        if(null == addOrder.getUserCode() || addOrder.getUserCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"用户编号为空",null);
        }
        List<String>cartCodeList = Arrays.asList(addOrder.getCartCode().split(","));
        String msg = "";
        //生成随机编号
        addOrder.setOrderCode(RandomCode.radmonkey());
        //新增订单
        int result = orderDao.addUserOrder(addOrder);
        if(result > 0){
            msg = "初始化订单成功!";
            List<String>newCartCodeList = new ArrayList<>();
            //查询有没有商品已经下架,返回已经下架的 购物车编号  已下架的商品无法购买
            List<GoodsExpired> goodsOnShelves = orderDao.goodsExpired(cartCodeList);
            if(goodsOnShelves.size() > 0){
                //将CartCodeList去除已过期的商品
                msg = msg + "已经清除已下架的商品"+goodsOnShelves.size()+"个!";
                boolean con;
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
            //查询待新增的 订单商品列表
            if(newCartCodeList.size() > 0){
                //接下来，判断购物车中 其 每种商品的数量库存 是否 大于等于 购物车中的 每种商品数量 返回的是那些不符合数量的商品编号
                List<GoodBigThanLibs> nonConformingProducts = orderDao.judgementStock(newCartCodeList);
                if(nonConformingProducts.size() > 0){
                    //将那些购物车的数量修改为当前商品库存的库存的最大数量，如果商品数量库存当前为0，也要替换。
                    String updateCodeList = "";
                    int index = 0;
                    String str = ",";
                    for(GoodBigThanLibs goodBigThanLibs:nonConformingProducts){
                        if(index == 0){
                            str = "";
                        }
                        updateCodeList = updateCodeList+goodBigThanLibs.getGoodCode()+str;
                    }
                    int updateNum = orderDao.updateGoodNum(Arrays.asList(updateCodeList.split(",")));
                    if(updateNum > 0){
                        msg = msg + "已更新部分购物车商品数量!";
                    }
                }
                //[默认支付成功] 生成订单后， 需要10分钟之内进行支付，否则 订单删除，商品库存恢复，如果支付成功，那么将纪录添加到顾客表
                List<Order> orderList = orderDao.queryOrderList(newCartCodeList);
                for(int i = 0;i < orderList.size();i++){
                    orderList.get(i).setOrderGCode(RandomCode.radmonkey());
                    orderList.get(i).setOrderCode(addOrder.getOrderCode());
                }
                //给每个订单商品详情随机生成订单详情编号
                //新增到订单详情 表
                if(orderList.size() > 0){
                    result = orderDao.addOrderList(orderList);
                    if(result > 0){
                        //添加到顾客表 addOrder 和订单编号
                        Customer customer = orderDao.queryCustomerData(addOrder.getUserCode());
                        customer.setCustomerCode(RandomCode.radmonkey());
                        customer.setUserCode(addOrder.getUserCode());
                        customer.setCustomerOrder(addOrder.getOrderCode());
                        System.out.println(customer.toString());
                        result = orderDao.addCustomer(customer);
                        if(result > 0){
                            msg = msg + "新建客户成功!";
                        }
                        //清空购物车
                        int empty = orderDao.clearEmpty(cartCodeList);
                        if(empty > 0){
                            msg = msg + "已清空购物车!";
                        }
                        return new ResponceData(ResponceDataState.values()[0].getCode(),msg,null);
                    }
                }
            }
            //更新订单的状态为 订单取消
            return new ResponceData(ResponceDataState.values()[3].getCode(),msg+"新增订单失败,您购物车内的商品均被抢空或者下架!",null);
        }
        //判断结果
        return new ResponceData(ResponceDataState.values()[3].getCode(),"新增订单失败",null);
    }

    /**
     * app端-用户-查询订单详情
     * @return
     */
    public ResponceData queryOrderDetail(OrderDetail orderDetail){
        if(null == orderDetail.getOrderCode() || orderDetail.getOrderCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"订单编号为空!",null);
        }
        //查询订单详情 以及 还没有转化成地址的 省市区编号[因为无法用一次sql查出省市区名称，所以我分两步来写，分一半也行，不过代码比较复杂]
        OrderDetail orderDetailOut = orderDao.queryOrderDetail(orderDetail.getOrderCode());
        //查询省市区名称
        DriverResponsibleArea driverResponsibleArea = new DriverResponsibleArea();
        driverResponsibleArea.setCityCode(orderDetailOut.getCityCode());
        driverResponsibleArea.setDistinctCode(orderDetailOut.getDistinctCode());
        driverResponsibleArea.setProvinceCode(orderDetailOut.getProvinceCode());
        AreaName areaNameList = driverDao.queryPCD(driverResponsibleArea);
        //将信息传值输出实体类
        OrderDetailOut orderDetailOutFinal = new OrderDetailOut();
        //赋值给输出实体类
        String address = areaNameList.getProvinceName()+areaNameList.getCityName()+areaNameList.getDistinctName()+orderDetailOut.getDetailAddress();
        orderDetailOutFinal.setDeliveryAddress(address);
        orderDetailOutFinal.setDeliveryStore(orderDetailOut.getDeliveryStore());
        orderDetailOutFinal.setOrderCode(orderDetailOut.getOrderCode());
        orderDetailOutFinal.setOrderCreateTime(orderDetailOut.getOrderCreateTime());
        orderDetailOutFinal.setOrderGoodsList(orderDetailOut.getOrderGoodsList());
        orderDetailOutFinal.setOrderState(orderDetailOut.getOrderState());
        if(null != orderDetailOut.getOrderCode()){
            //输出实体类
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询订单成功!",orderDetailOutFinal);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询订单失败",null);
    }
    /**
     * 修改订单状态
     * @param updateOrder
     * @return
     */
    public ResponceData updateOrder(UpdateOrder updateOrder){
        if(null == updateOrder.getOrderCode()){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"订单编号为空!",null);
        }
        if(updateOrder.getOrderState() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"订单状态不能为0!",null);
        }
        //获取当前修改人的Id
        updateOrder.setUpdateUser(SecurityUtils.getCurrentUserId());
        //查询
        int result = orderDao.updateOrder(updateOrder);
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"更新状态成功!",null);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }

    /**
     * 查询订单列表
     * @param orderListParam
     * @return
     */
    public ResponceData queryUserOrderList(OrderListParam orderListParam){
        if(null == orderListParam.getUserCode()){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"用户编号为空!",null);
        }
        List<OrderList>orderLists = orderDao.queryUserOrderList(orderListParam);
        if(orderLists.size() > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",orderLists);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }

    /**
     * 增加订单商品评价
     * @param orderEva
     * @return
     */
    public ResponceData addOrderGoodsEva(OrderEva orderEva){
        //开始处理对象
        if(null == orderEva.getOrderCode()){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"订单编号缺失!",orderEva);
        }
        //为每件商品评价生成编号
        orderEva.setUserCode(SecurityUtils.getCurrentUserId());
        for(int i = 0;i < orderEva.getEvaList().size();i++){
            orderEva.getEvaList().get(i).setCommentCode(RandomCode.radmonkey());
            orderEva.getEvaList().get(i).setCreateUser(orderEva.getUserCode());
        }
        //当前用户-新增至商品评价列表
        int result = orderDao.addOrderGoodsEva(orderEva.getEvaList(),orderEva.getOrderCode());
        //更新至订单评价

        if(result > 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"添加商品评论成功!",result);
        }
        //判断结果
        return new ResponceData(ResponceDataState.values()[3].getCode(),"添加商品评论失败!",result);
    }
}
