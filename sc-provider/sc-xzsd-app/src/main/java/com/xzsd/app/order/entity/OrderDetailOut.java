package com.xzsd.app.order.entity;

import java.util.List;

/**
 * 订单详情实体类
 */
public class OrderDetailOut {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     *取货地址
     */
    private String deliveryAddress;
    /**
     *取货门店
     */
    private String deliveryStore;
    /**
     *订单创建时间
     */
    private String orderCreateTime;
    /**
     *订单状态
     */
    private int orderState;
    /**
     *订单商品详情列表
     */
    private List<OrderDetailGoodsList> orderGoodsList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryStore() {
        return deliveryStore;
    }

    public void setDeliveryStore(String deliveryStore) {
        this.deliveryStore = deliveryStore;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public List<OrderDetailGoodsList> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderDetailGoodsList> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }
}
