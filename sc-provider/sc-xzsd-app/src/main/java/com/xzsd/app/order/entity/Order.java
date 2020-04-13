package com.xzsd.app.order.entity;

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
    private String goodPrice;
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

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
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
