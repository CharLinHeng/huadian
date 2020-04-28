package com.xzsd.app.order.entity;

/**
 * 立即购买  新增订单实体类
 */
public class BuyNow {
    private String goodCode;
    /**
     * 商品数量
     */
    private int goodNum;
    /**
     * 门店编号，也就是取货门店
     */
    private String shopCode;
    /**
     *订单编号
     */
    private String orderCode;
    /**
     *用户编号
     */
    private String userCode;
    /**
     *订单价格
     */
    private double orderPrice;
    /**
     * 订单描述
     */
    private String orderPre;

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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderPre() {
        return orderPre;
    }

    public void setOrderPre(String orderPre) {
        this.orderPre = orderPre;
    }
}
