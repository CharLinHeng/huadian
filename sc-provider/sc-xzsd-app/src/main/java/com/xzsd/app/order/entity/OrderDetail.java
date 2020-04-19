package com.xzsd.app.order.entity;

import java.util.List;

/**
 * 订单详情实体类
 */
public class OrderDetail {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     *取货地址
     */
    private String provinceCode;
    private String cityCode;
    private String distinctCode;
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
     * 取货详细地址
     */
    private String detailAddress;

    /**
     *订单商品详情列表
     */

    private List<OrderDetailGoodsList> orderGoodsList;

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
    public String getDetailAddress() {
        return detailAddress;
    }
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }



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
