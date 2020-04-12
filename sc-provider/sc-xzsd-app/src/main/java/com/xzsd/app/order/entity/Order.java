package com.xzsd.app.order.entity;

public class Order {
    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 支付状态
     */
    private String payState;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }
}
