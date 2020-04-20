package com.xzsd.pc.rotaChart.entity;

public class GoodList {
    /**
     * 货物编号
     */
    private String goodCode;

    /**
     * 货物名称
     */
    private String goodName;

    /**
     * 商品价格
     */
    private double goodPrice;
    /**
     * 商品销售的数量
     */
    private int goodSaleNum;

    /**
     * 商品一级分类
     */
    private String goodOneClass;
    /**
     * 商品二级分类
     */
    private String goodSecClass;

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

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public int getGoodSaleNum() {
        return goodSaleNum;
    }

    public void setGoodSaleNum(int goodSaleNum) {
        this.goodSaleNum = goodSaleNum;
    }

    public String getGoodOneClass() {
        return goodOneClass;
    }

    public void setGoodOneClass(String goodOneClass) {
        this.goodOneClass = goodOneClass;
    }

    public String getGoodSecClass() {
        return goodSecClass;
    }

    public void setGoodSecClass(String goodSecClass) {
        this.goodSecClass = goodSecClass;
    }
}
