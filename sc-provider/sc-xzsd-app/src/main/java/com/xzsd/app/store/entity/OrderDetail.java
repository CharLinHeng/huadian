package com.xzsd.app.store.entity;

import java.util.List;

/**
 * 店长订单
 */
public class OrderDetail {
    /**
     *订单编号
     */
    private String orderCode;
    /**
     * 订单取货地址 省市区编号
     */
    private String provinceCode;
    /**
     * 市编号
     */
    private String cityCode;
    /**
     * 区编号
     */
    private String distinctCode;
    /**
     * 详细
     */
    private String deliveryAddress;
    /**
     *订单取货门店名称
     */
    private String deliveryStore;
    /**
     *订单创建时间
     */
    private String orderCreateTime;
    /**
     *订单状态
     */
    private String orderState;
    /**
     *用户名字
     */
    private String userName;
    /**
     *用户手机号
     */
    private String userPhone;
    /**
     *订单商品列表详情
     */
    private List<OrderDetailGood> orderGoodsList;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistinctCode() {
        return distinctCode;
    }

    public void setDistinctCode(String distinctCode) {
        this.distinctCode = distinctCode;
    }

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

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public List<OrderDetailGood> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderDetailGood> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }
}
