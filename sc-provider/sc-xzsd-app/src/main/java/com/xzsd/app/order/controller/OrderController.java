package com.xzsd.app.order.controller;

import com.xzsd.app.order.entity.AddOrder;
import com.xzsd.app.order.entity.OrderDetail;
import com.xzsd.app.order.service.OrderService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
