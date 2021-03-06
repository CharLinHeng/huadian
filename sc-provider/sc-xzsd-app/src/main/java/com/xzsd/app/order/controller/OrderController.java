package com.xzsd.app.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.order.entity.*;
import com.xzsd.app.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Auther: zhonghecheng
 * @Date: 2020年4月15日19:50:20
 * @Description: APP端-用户订单Controller
 */
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
    public AppResponse addUserOrder(AddOrder addOrder){
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
    public AppResponse queryOrderDetail(OrderDetail orderDetail){
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
    public AppResponse updateOrder(UpdateOrder updateOrder){
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
    public AppResponse queryUserOrderList(OrderListParam orderListParam){
        try{
            return orderService.queryUserOrderList(orderListParam);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 新增订单商品评价
     * @param evaJson
     * @return
     */

    @PostMapping("addOrderGoodsEva")
    public AppResponse addOrderGoodsEva(EvaJson evaJson){
        try{
            return orderService.addOrderGoodsEva(evaJson);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 快速购买
     * @param buyNow
     * @return
     */
    @PostMapping("fastBuyGoods")
    public AppResponse fastBuyGoods(BuyNow buyNow){
        try{
            return orderService.buyNow(buyNow);
        }catch (Exception e){
            throw e;
        }
    }
}
