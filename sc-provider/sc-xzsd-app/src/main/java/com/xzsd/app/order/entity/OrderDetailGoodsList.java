package com.xzsd.app.order.entity;

/**
 * 查询订单详情时的订单的每件商品实体类
 */
public class OrderDetailGoodsList {
    /**
     *商品编号
     */
    private String  goodCode;
    /**
     *商品名称
     */
    private String goodName;
    /**
     *商品售价
     */
    private String goodSale;
    /**
     *商品介绍
     */
    private String goodPrec;
    /**
     *商品数量
     */
    private int goodNum;
    /**
     * 商品图片地址
     */
    private String goodImageUrl;

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

    public String getGoodSale() {
        return goodSale;
    }

    public void setGoodSale(String goodSale) {
        this.goodSale = goodSale;
    }

    public String getGoodPrec() {
        return goodPrec;
    }

    public void setGoodPrec(String goodPrec) {
        this.goodPrec = goodPrec;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public String getGoodImageUrl() {
        return goodImageUrl;
    }

    public void setGoodImageUrl(String goodImageUrl) {
        this.goodImageUrl = goodImageUrl;
    }
}
