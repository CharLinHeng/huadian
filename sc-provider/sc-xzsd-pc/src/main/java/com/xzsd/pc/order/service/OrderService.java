package com.xzsd.pc.order.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.User;
import com.xzsd.pc.util.SecurityUtils;
import org.springframework.stereotype.Service;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.*;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * @Description 订单服务实现类
 * @author zhc
 * @date 2020-3-31
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private CustomerDao customerDao;
    /**
     * 订单列表查询
     * @param orderQuery
     * @return
     */
    public AppResponse queryOrderList(OrderQuery orderQuery){
        //从Redis中根据token获取用户编号,然后根据用户编号进行获取角色
        String userCode = SecurityUtils.getCurrentUserUsername();
        //根据账号获取当前用户的角色和编号
        User user = customerDao.queryCurrUser(userCode);
        if(null == user){
            return AppResponse.bizError("账号没找到或者司机不能查看此模块，请重新登入!");
        }
        orderQuery.setUserCode(user.getUserCode());
        orderQuery.setUserRole(user.getUserRole());
        //查询
        PageHelper.startPage(orderQuery.getPageNum(),orderQuery.getPageSize());
        List<Order>orderList = orderDao.queryOrderList(orderQuery);
        PageInfo<Order>orderPageInfo = new PageInfo<>(orderList);
        //返回
        if(orderList.size() > 0 ){
            return AppResponse.success("查询成功1!",orderPageInfo);
        }
        return AppResponse.paramError("查询为空!");
    }
    /**
     * 订单状态修改
     * @param codes
     * @param orderUpdate
     * @return
     */
    public AppResponse updateOrderState(String codes, OrderUpdate orderUpdate){
        //订单的订单编号参数
        if(null == codes || codes == ""){
            return AppResponse.paramError("编号参数为空!");
        }
        List<String>stringList = Arrays.asList(codes.split(","));
        if(stringList.size()  == 0){
            return AppResponse.paramError("修改数量为空!");
        }
        //订单的状态需要 指定
        if(null == orderUpdate.getOrderState() || orderUpdate.getOrderState() == ""){
            return AppResponse.paramError("订单状态需指定!");
        }
        //暂时没有修改者，自己创建
        String msg = "版本号没指定，或者当前为0,可能会修改不成功";
        if(orderUpdate.getVersion() > 0){
                msg = "";
        }
        //修改
        int result = orderDao.updateOrderState(stringList,Integer.parseInt(orderUpdate.getOrderState()),
                orderUpdate.getUpdateUser(), orderUpdate.getVersion());
        if(result > 0 ){
            return AppResponse.success("修改成功!",result);
        }
        return AppResponse.bizError("修改失败!");
    }
    /**
     * 订单详情查询
     * @param pageEntity
     * @return
     */
    public AppResponse queryOrderDetail(PageEntity pageEntity){
        if (null == pageEntity.getOrderCode() || pageEntity.getOrderCode() == "") {
            return AppResponse.paramError("订单编号参数为空!");
        }
        //查询
        PageHelper.startPage(pageEntity.getPageNum(),pageEntity.getPageSize());
        List<OrderDetail>orderDetailList = orderDao.queryOrderDetail(pageEntity.getOrderCode());
        PageInfo<OrderDetail>orderDetailPageInfo = new PageInfo<>(orderDetailList);
        if(orderDetailList.size() == 0){
            return AppResponse.success("查询为空!");
        }
        return AppResponse.success("查询成功!",orderDetailPageInfo);
    }
}
