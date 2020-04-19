package com.xzsd.app.order.entity;

/**
 * 更新订单实体类
 */
public class UpdateOrder {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private int orderState;
    /**
     * 更新者
     */
    private String updateUser;

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

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
}
