package com.xzsd.pc.goods.entity;


/**
 * 商品实体
 * author:zhc
 * time: 2020年3月25日15:25:15
 */
public class Good {
    /**
     * 货物编号
     */
    private String goodCode;
    /**
     * 商家名称
     */
    private String storeName;
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
     * 商品一级分类
     */
    private String goodFirstClas;
    /**
     * 商品二级分类
     */
    private String goodSecondClas;

    /**
     * 商品广告
     */
    private String goodAd;
    /**
     * 商品描述
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
     * 商品下架时间
     */
    private String goodSaleEnd;
    /**
     * 商品评价等级
     */
    private double goodEvaRank;
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
     * 商品出版社
     */
    private  String goodCommodityPress;
    /**
     * 商品书号
     */
    private String goodIsbnBookSize;
    /**
     * 商品图片地址
     */
    private String goodImageUrl;

    /**
     * 商品是否弃用
     */
    private int isDelete;
    /**
     * 页分页号
     */
    private int pageSize;
    /**
     * 分页数量
     */
    private int pageNum;

    /**
     * 商品创建用户
     *
     */
    private String createUser;
    /**
     * 商品更新用户
     */
    private String updateUser;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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

    public String getGoodFirstClas() {
        return goodFirstClas;
    }

    public void setGoodFirstClas(String goodFirstClas) {
        this.goodFirstClas = goodFirstClas;
    }

    public String getGoodSecondClas() {
        return goodSecondClas;
    }

    public void setGoodSecondClas(String goodSecondClas) {
        this.goodSecondClas = goodSecondClas;
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

    public String getGoodSaleEnd() {
        return goodSaleEnd;
    }

    public void setGoodSaleEnd(String goodSaleEnd) {
        this.goodSaleEnd = goodSaleEnd;
    }

    public double getGoodEvaRank() {
        return goodEvaRank;
    }

    public void setGoodEvaRank(double goodEvaRank) {
        this.goodEvaRank = goodEvaRank;
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

    public String getGoodCommodityPress() {
        return goodCommodityPress;
    }

    public void setGoodCommodityPress(String goodCommodityPress) {
        this.goodCommodityPress = goodCommodityPress;
    }

    public String getGoodIsbnBookSize() {
        return goodIsbnBookSize;
    }

    public void setGoodIsbnBookSize(String goodIsbnBookSize) {
        this.goodIsbnBookSize = goodIsbnBookSize;
    }

    public String getGoodImageUrl() {
        return goodImageUrl;
    }

    public void setGoodImageUrl(String goodImageUrl) {
        this.goodImageUrl = goodImageUrl;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


}
