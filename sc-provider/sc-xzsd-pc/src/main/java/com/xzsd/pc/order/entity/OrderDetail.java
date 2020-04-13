package com.xzsd.pc.order.entity;

public class OrderDetail {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 商品编号
     */
    private String goodCode;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品数量
     */
    private String goodNum;

    /**
     * 总金额
     */
    private double goodCount;

    /**
     * 商品价格
     */
    private String goodPrice;

    /**
     * 售价
     */
    private String goodSalePri;

    public String getUserCode() {
        return userCode;
    }

    public double getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(double goodCount) {
        this.goodCount = goodCount;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodSalePri() {
        return goodSalePri;
    }

    public void setGoodSalePri(String goodSalePri) {
        this.goodSalePri = goodSalePri;
    }
}
