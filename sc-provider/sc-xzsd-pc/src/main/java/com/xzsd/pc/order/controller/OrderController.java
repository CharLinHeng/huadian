package com.xzsd.pc.order.controller;
import com.neusoft.core.restful.AppResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.order.entity.OrderQuery;
import com.xzsd.pc.order.entity.OrderUpdate;
import com.xzsd.pc.order.entity.PageEntity;
import com.xzsd.pc.order.service.OrderService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 订单Controller
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private AppResponse AppResponse;
    @Resource
    private OrderService orderService;
    @ResponseBody
    /**
     * 订单列表查询
     */
    @PostMapping("queryOrderList")
    public AppResponse queryOrderList(OrderQuery orderQuery){
        try{
            return orderService.queryOrderList(orderQuery);
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
    public AppResponse updateOrderState(OrderUpdate orderUpdate, HttpServletRequest httpServletRequest){
        try{
            String codes = httpServletRequest.getParameter("orderCode");
            return orderService.updateOrderState(codes,orderUpdate);
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
    public AppResponse queryOrderDetail(PageEntity pageEntity){
        try{
            return orderService.queryOrderDetail(pageEntity);
        }catch (Exception e){
            throw e;
        }
    }

}
