package com.xzsd.pc.orderManage.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.orderManage.entity.OrderQuery;
import com.xzsd.pc.orderManage.entity.OrderUpdate;
import com.xzsd.pc.orderManage.entity.PageEntity;
import com.xzsd.pc.orderManage.service.OrderService;
import com.xzsd.pc.util.ResponceData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 订单Controller
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private ResponceData responceData;
    @Resource
    private OrderService orderService;

    @ResponseBody
    /**
     * 订单列表查询
     */
    @PostMapping("queryOrderList")
    public ResponceData queryOrderList(OrderQuery orderQuery){
        try{


            responceData = orderService.queryOrderList(orderQuery);
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 订单状态修改
     * @param orderUpdate
     * @param httpServletRequest
     * @return
     */
    @PostMapping("updateOrderState")
    public ResponceData updateOrderState(OrderUpdate orderUpdate, HttpServletRequest httpServletRequest){
        try{
            String codes = httpServletRequest.getParameter("orderCode");
            responceData = orderService.updateOrderState(codes,orderUpdate);
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 订单详情查询
     * @param
     * @return
     */
    @PostMapping("queryOrderDetail")
    public ResponceData queryOrderDetail(PageEntity pageEntity){
        try{
            responceData = orderService.queryOrderDetail(pageEntity);
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }

}
