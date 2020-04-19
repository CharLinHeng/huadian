package com.xzsd.app.store.entity;

/**
 * 店长端-更新订单
 */
public class OrderUpdate {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private int orderState;
    /**
     * 更细者
     */
    private String updateUser;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
