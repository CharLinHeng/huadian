package com.xzsd.app.order.entity;

/**
 * 订单商品列表详情实体类
 */
public class OrderListUnit {
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     *商品售价
     */
    private String goodSale;
    /**
     *商品数量
     */
    private String goodNum;
    /**
     * 商品图片
     */
    private String imageUrl;
    /**
     * 商品广告
     */
    private String goodAd;
    /**
     * 商品介绍
     */
    private String goodPre;

    public String getGoodAd() {
        return goodAd;
    }

    public void setGoodAd(String goodAd) {
        this.goodAd = goodAd;
    }

    public String getGoodPre() {
        return goodPre;
    }

    public void setGoodPre(String goodPre) {
        this.goodPre = goodPre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }
}
