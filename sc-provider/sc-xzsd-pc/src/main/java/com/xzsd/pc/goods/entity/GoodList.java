package com.xzsd.pc.goods.entity;
/**
 * 商品实体
 * author:zhc
 * time: 2020年3月25日15:25:15
 */
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
     * 商品销售价格
     */
    private double goodSellingPrice;

    /**
     * 商品销售的数量
     */
    private int goodSaleNum;

    /**
     * 商品一级分类名称
     */
    private String goodFirstClasName;
    /**
     * 商品二级分类名称
     */
    private String goodSecondClasName;

    /**
     * 商品广告
     */
    private String goodAd;
    /**
     * 商品介绍
     */
    private String goodPrec;
    /**
     * 商品状态
     */
    private int goodState;
    /**
     * 商品销售时间
     */
    private String goodSaleTime;
    /**
     * 商品浏览量
     */
    private int goodThroughNum;
    /**
     * 商品库存
     */
    private int goodLibSave;
    /**
     * 商品作者
     */
    private String goodAuthor;

    /**
     * 商品书号
     */
    private String goodIsbnBookSize;
    /**
     * 商品出版社
     */
    private  String goodCommodityPress;
    /**
     * 商家名称
     */
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGoodCommodityPress() {
        return goodCommodityPress;
    }

    public void setGoodCommodityPress(String goodCommodityPress) {
        this.goodCommodityPress = goodCommodityPress;
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

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public double getGoodSellingPrice() {
        return goodSellingPrice;
    }

    public void setGoodSellingPrice(double goodSellingPrice) {
        this.goodSellingPrice = goodSellingPrice;
    }

    public int getGoodSaleNum() {
        return goodSaleNum;
    }

    public void setGoodSaleNum(int goodSaleNum) {
        this.goodSaleNum = goodSaleNum;
    }

    public String getGoodFirstClasName() {
        return goodFirstClasName;
    }

    public void setGoodFirstClasName(String goodFirstClasName) {
        this.goodFirstClasName = goodFirstClasName;
    }

    public String getGoodSecondClasName() {
        return goodSecondClasName;
    }

    public void setGoodSecondClasName(String goodSecondClasName) {
        this.goodSecondClasName = goodSecondClasName;
    }

    public String getGoodAd() {
        return goodAd;
    }

    public void setGoodAd(String goodAd) {
        this.goodAd = goodAd;
    }

    public String getGoodPrec() {
        return goodPrec;
    }

    public void setGoodPrec(String goodPrec) {
        this.goodPrec = goodPrec;
    }

    public int getGoodState() {
        return goodState;
    }

    public void setGoodState(int goodState) {
        this.goodState = goodState;
    }

    public String getGoodSaleTime() {
        return goodSaleTime;
    }

    public void setGoodSaleTime(String goodSaleTime) {
        this.goodSaleTime = goodSaleTime;
    }


    public int getGoodThroughNum() {
        return goodThroughNum;
    }

    public void setGoodThroughNum(int goodThroughNum) {
        this.goodThroughNum = goodThroughNum;
    }

    public int getGoodLibSave() {
        return goodLibSave;
    }

    public void setGoodLibSave(int goodLibSave) {
        this.goodLibSave = goodLibSave;
    }

    public String getGoodAuthor() {
        return goodAuthor;
    }

    public void setGoodAuthor(String goodAuthor) {
        this.goodAuthor = goodAuthor;
    }

    public String getGoodIsbnBookSize() {
        return goodIsbnBookSize;
    }

    public void setGoodIsbnBookSize(String goodIsbnBookSize) {
        this.goodIsbnBookSize = goodIsbnBookSize;
    }


}
