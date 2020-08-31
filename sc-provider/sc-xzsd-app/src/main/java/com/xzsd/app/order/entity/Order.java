package com.xzsd.app.order.entity;
/**
 *订单实体类
 */
public class Order {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单详情列表编号
     */
    private String orderGCode;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     * 商品购买的数量
     */
    private int goodNum;
    /**
     * 商品价格
     */
    private double goodPrice;
    /**
     * 商品图片地址
     */
    private String goodImage;
    /***
     * 创建用户
     */
    private String createUser;
    /**
     * 支付状态
     */
    private String payState;
    /**
     * 门店名称
     */
    private String shopCode;
    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderGCode() {
        return orderGCode;
    }

    public void setOrderGCode(String orderGCode) {
        this.orderGCode = orderGCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(String goodImage) {
        this.goodImage = goodImage;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }
}
