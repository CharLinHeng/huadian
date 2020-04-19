package com.xzsd.app.order.controller;

import com.xzsd.app.order.entity.*;
import com.xzsd.app.order.service.OrderService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class OrderController {
    @Resource
    private OrderService orderService;
    @ResponseBody
    /**
     * 增加订单
     */
    @PostMapping("addUserOrder")
    public ResponceData addUserOrder(AddOrder addOrder){
        try{
            return orderService.addUserOrder(addOrder);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderDetail
     * @return
     */
    @PostMapping("queryOrderDetail")
    public ResponceData queryOrderDetail(OrderDetail orderDetail){
        try{
            return orderService.queryOrderDetail(orderDetail);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param updateOrder
     * @return
     */
    @PostMapping("updateOrder")
    public ResponceData updateOrder(UpdateOrder updateOrder){
        try{
            return orderService.updateOrder(updateOrder);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 用户订单列表查询
     * @param orderListParam
     * @return
     */
    @PostMapping("queryUserOrderList")
    public ResponceData queryUserOrderList(OrderListParam orderListParam){
        try{
            return orderService.queryUserOrderList(orderListParam);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 新增订单商品评价
     * @param orderEva
     * @return
     */
    @PostMapping(value = "addOrderGoodsEva",headers = {"content-type=application/json"})
    public ResponceData addOrderGoodsEva(@RequestBody OrderEva orderEva){
        try{
            return orderService.addOrderGoodsEva(orderEva);
        }catch (Exception e){
            throw e;
        }
    }
}
