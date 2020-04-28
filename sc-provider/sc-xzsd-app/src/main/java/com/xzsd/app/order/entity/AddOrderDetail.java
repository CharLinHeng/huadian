package com.xzsd.app.order.entity;

/**
 * 单独购买的 - 订单商品详情列表
 */
public class AddOrderDetail {
    private String orderGCode;
    /**
     *订单编号
     */
    private String orderCode;
    /**
     *订单名字
     */
    private String orderGName;
    /**
     *商品编号
     */
    private String goodCode;
    /**
     *订单价格总计
     */
    private double orderGCount;
    /**
     *订单商品数量
     */
    private int orderGNum;
    /**
     *订单商品价格
     */
    private double orderGPrice;
    /**
     *商品描述
     */
    private String orderGPre;
    /**
     *订单图片
     */
    private String orderGImage;
    /**
     *订单商品列表详情创建用户
     */
    private String createUser;

    public int getOrderGNum() {
        return orderGNum;
    }

    public void setOrderGNum(int orderGNum) {
        this.orderGNum = orderGNum;
    }

    public String getOrderGCode() {
        return orderGCode;
    }

    public void setOrderGCode(String orderGCode) {
        this.orderGCode = orderGCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderGName() {
        return orderGName;
    }

    public void setOrderGName(String orderGName) {
        this.orderGName = orderGName;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public double getOrderGCount() {
        return orderGCount;
    }

    public void setOrderGCount(double orderGCount) {
        this.orderGCount = orderGCount;
    }

    public double getOrderGPrice() {
        return orderGPrice;
    }

    public void setOrderGPrice(double orderGPrice) {
        this.orderGPrice = orderGPrice;
    }
    public String getOrderGPre() {
        return orderGPre;
    }

    public void setOrderGPre(String orderGPre) {
        this.orderGPre = orderGPre;
    }

    public String getOrderGImage() {
        return orderGImage;
    }

    public void setOrderGImage(String orderGImage) {
        this.orderGImage = orderGImage;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
