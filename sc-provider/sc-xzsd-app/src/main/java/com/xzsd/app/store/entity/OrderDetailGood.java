package com.xzsd.app.store.entity;
/**
 * 店长订单详情 - 的商品
 */
public class OrderDetailGood {
    /**
     *商品编号
     */
    private String goodCode;
    /**
     *商品名称
     */
    private String goodName;
    /**
     *商品售价
     */
    private String goodSale;
    /**
     *商品描述
     */
    private String goodPrec;
    /**
     *商品数量
     */
    private String goodNum;
    /**
     * 商品图片地址
     */
    private String goodImage;

    public String getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(String goodImage) {
        this.goodImage = goodImage;
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

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }
}
