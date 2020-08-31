package com.xzsd.pc.order.entity;
/**
 * 订单更新实体类
 */
public class OrderUpdate {
    /**
     * 订单状态
     */
    private String  orderState;
    /**
     * 订单更新用户
     */
    private String updateUser;
    /**
     * 订单版本号
     */
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
