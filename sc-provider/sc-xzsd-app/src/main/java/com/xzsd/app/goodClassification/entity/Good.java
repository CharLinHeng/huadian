package com.xzsd.app.goodClassification.entity;

/**
 * 商品实体
 */
public class Good {
    /**
     * 商品编号
     */
    private String goodCode;

    /**
     * 商品图片地址
     */
    private String goodImageUrl;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品价格
     */
    private String goodPrice;
    /**
     * 商品售价
     */
    private String goodSale;

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodImageUrl() {
        return goodImageUrl;
    }

    public void setGoodImageUrl(String goodImageUrl) {
        this.goodImageUrl = goodImageUrl;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodSale() {
        return goodSale;
    }

    public void setGoodSale(String goodSale) {
        this.goodSale = goodSale;
    }
}
