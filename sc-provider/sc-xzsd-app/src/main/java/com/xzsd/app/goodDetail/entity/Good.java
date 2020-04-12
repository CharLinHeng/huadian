package com.xzsd.app.goodDetail.entity;
/**
 * @Deprecated 商品详情页面的实体类
 * @author zhc
 * @Time 2020年4月10日15:22:38
 */
public class Good {
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 商品介绍
     */
    private String goodPric;
    /**
     *商品库存数量
     */
    private String goodNum;
    /**
     *商品价格
     */
    private String goodPrice;
    /**
     *商品售价
     */
    private String goodSale;
    /**
     *商品图片地址
     */
    private String goodImageList;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodPric() {
        return goodPric;
    }

    public void setGoodPric(String goodPric) {
        this.goodPric = goodPric;
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

    public String getGoodSale() {
        return goodSale;
    }

    public void setGoodSale(String goodSale) {
        this.goodSale = goodSale;
    }

    public String getGoodImageList() {
        return goodImageList;
    }

    public void setGoodImageList(String goodImageList) {
        this.goodImageList = goodImageList;
    }
}
