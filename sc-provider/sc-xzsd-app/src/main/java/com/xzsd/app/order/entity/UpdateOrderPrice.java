package com.xzsd.app.order.entity;
/**
 *更新订单价格
 */
public class UpdateOrderPrice {
    /**
     *订单编号
     */
    private String orderCode;
    /**
     *价格
     */
    private double price;
    /**
     *更新用户
     */
    private String updateUser;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
