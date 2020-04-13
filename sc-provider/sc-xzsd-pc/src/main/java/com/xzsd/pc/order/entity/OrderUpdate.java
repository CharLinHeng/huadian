package com.xzsd.pc.order.entity;

public class OrderUpdate {

    private String  orderState;
    private String updateUser;
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

    @Override
    public String toString() {
        return "OrderUpdate{" +
                "orderState='" + orderState + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", version=" + version +
                '}';
    }
}
