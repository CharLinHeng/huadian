package com.xzsd.app.store.entity;

/**
 * 订单列表的商品详情
 */
public class StoreOrderListUnit {
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
    private double goodSale;
//    /**
//     *商品描述
//     */
//    private String goodPrec;
    /**
     *商品数量
     */
    private int goodNum;

    /**
     * 商品图片
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

    public double getGoodSale() {
        return goodSale;
    }

    public void setGoodSale(double goodSale) {
        this.goodSale = goodSale;
    }

//    public String getGoodPrec() {
//        return goodPrec;
//    }
//
//    public void setGoodPrec(String goodPrec) {
//        this.goodPrec = goodPrec;
//    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }
}
