package com.xzsd.pc.order.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.User;
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
    private ResponceData responceData;
    @Resource
    private OrderDao orderDao;
    @Resource
    private CustomerDao customerDao;
    /**
     * 订单列表查询
     * @param orderQuery
     * @return
     */
    public ResponceData queryOrderList(OrderQuery orderQuery){
        //判断必要的是否为空
        if(orderQuery.getPageNum() == 0 || orderQuery.getPageSize() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"页号或者页数量不能为空!",null);
        }
        //从Redis中根据token获取用户编号,然后根据用户编号进行获取角色
        //因为还没写登入，所以这里指定一个账户
        String userCode = "20200324222349013251934814478747";
        User user = customerDao.queryCurrUser(userCode);
        orderQuery.setUserCode(user.getUserCode());
        orderQuery.setUserRole(user.getUserRole());
        //查询
        PageHelper.startPage(orderQuery.getPageNum(),orderQuery.getPageSize());
        List<Order>orderList = orderDao.queryOrderList(orderQuery);
        PageInfo<Order>orderPageInfo = new PageInfo<>(orderList);
        //返回
        if(orderList.size() > 0 ){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功1!",orderPageInfo);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }
    /**
     * 订单状态修改
     * @param codes
     * @param orderUpdate
     * @return
     */
    public ResponceData updateOrderState(String codes, OrderUpdate orderUpdate){
        if(null == codes || codes == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"编号参数为空!",null);
        }
        List<String>stringList = Arrays.asList(codes.split(","));
        if(stringList.size()  == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"修改数量为空!",null);
        }
        if(null == orderUpdate.getOrderState() || orderUpdate.getOrderState() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"订单状态需指定!",null);
        }
        //暂时没有修改者，自己创建
        String msg = "版本号没指定，或者当前为0,可能会修改不成功";
        if(orderUpdate.getVersion() > 0){
                msg = "";
        }
        //修改
        int result = orderDao.updateOrderState(stringList,Integer.parseInt(orderUpdate.getOrderState()),orderUpdate.getUpdateUser(),orderUpdate.getVersion());
        if(result > 0 ){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"修改成功!",result);
        }
        return new ResponceData(ResponceDataState.values()[0].getCode(),"修改失败!"+msg,result);
    }
    /**
     * 3订单详情查询
     * @param pageEntity
     * @return
     */
    public ResponceData queryOrderDetail(PageEntity pageEntity){
        int pageSize = pageEntity.getPageSize();
        int pageNum = pageEntity.getPageNum();
        if(pageSize == 0 || pageNum == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"页号或者页数量参数不能为0或者为空!",null);
        }
        if (null == pageEntity.getOrderCode() || pageEntity.getOrderCode() == "") {
            return new ResponceData(ResponceDataState.values()[3].getCode(),"订单编号参数为空!",null);
        }
        //查询
        PageHelper.startPage(pageNum,pageSize);
        List<OrderDetail>orderDetailList = orderDao.queryOrderDetail(pageEntity.getOrderCode());
        PageInfo<OrderDetail>orderDetailPageInfo = new PageInfo<>(orderDetailList);
        if(orderDetailList.size() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
        }
        return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",orderDetailPageInfo);
    }
}
