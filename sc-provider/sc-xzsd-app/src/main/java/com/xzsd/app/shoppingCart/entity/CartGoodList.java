package com.xzsd.app.shoppingCart.entity;

/**
 * 购物车列表查询
 */
public class CartGoodList {
    /**
     * 购物车编号
     */
    private String cartCode;
    /**
     *商品编号
     */
    private String goodCode;
    /**
     *商品名称
     */
    private String goodName;
    /**
     *商品数量
     */
    private int goodNum;
    /**
     *商品售价
     */
    private double goodSale;
    /**
     *商品图片地址
     */
    private String goodImageUrl;
    /**
     * 商品介绍
     */
    private String goodPre;
    /**
     *商品广告
     */
    private String goodAd;

    public String getGoodPre() {
        return goodPre;
    }

    public void setGoodPre(String goodPre) {
        this.goodPre = goodPre;
    }

    public String getGoodAd() {
        return goodAd;
    }

    public void setGoodAd(String goodAd) {
        this.goodAd = goodAd;
    }

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
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

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public double getGoodSale() {
        return goodSale;
    }

    public void setGoodSale(double goodSale) {
        this.goodSale = goodSale;
    }

    public String getGoodImageUrl() {
        return goodImageUrl;
    }

    public void setGoodImageUrl(String goodImageUrl) {
        this.goodImageUrl = goodImageUrl;
    }
}
