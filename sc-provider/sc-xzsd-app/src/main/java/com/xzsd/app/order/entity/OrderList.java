package com.xzsd.app.order.entity;

import java.util.List;

/**
 * 订单列表实体类
 */
public class OrderList {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     *订单状态
     */
    private String orderState;
    /**
     *商品列表详情
     */
    private List<OrderListUnit> orderGoodList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public List<OrderListUnit> getOrderGoodList() {
        return orderGoodList;
    }

    public void setOrderGoodList(List<OrderListUnit> orderGoodList) {
        this.orderGoodList = orderGoodList;
    }
}
