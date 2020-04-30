package com.xzsd.pc.hotGood.entity;

/**
 * 热门商品位列表查询实体
 */
public class HotGoodList {
    /**
     * 排序
     */
    private String hotGoodSort;

    /**
     * 编号
     */
    private String hotGoodCode;

    /**
     * 商品编号
     */
    private String goodCode;

    /**
     * 名称
     */
    private String goodName;

    /**
     * 价格
     */
    private String goodPrice;

    /**
     * 介绍
     */
    private String goodPre;

    public String getHotGoodSort() {
        return hotGoodSort;
    }

    public void setHotGoodSort(String hotGoodSort) {
        this.hotGoodSort = hotGoodSort;
    }

    public String getHotGoodCode() {
        return hotGoodCode;
    }

    public void setHotGoodCode(String hotGoodCode) {
        this.hotGoodCode = hotGoodCode;
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

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodPre() {
        return goodPre;
    }

    public void setGoodPre(String goodPre) {
        this.goodPre = goodPre;
    }
}
