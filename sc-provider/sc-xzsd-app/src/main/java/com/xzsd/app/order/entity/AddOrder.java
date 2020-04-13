package com.xzsd.app.order.entity;

public class AddOrder {
    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 购物车编号集合
     */
    private String cartCode;
    /**
     * 订单编号
     */
    private String orderCode;

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

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }
}
