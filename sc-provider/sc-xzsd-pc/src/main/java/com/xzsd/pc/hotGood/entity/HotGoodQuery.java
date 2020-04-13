package com.xzsd.pc.hotGoodManage.entity;

/**
 * 热门商品列表查询之 商品绑定 之 列表查询实体
 */
public class HotGoodQuery {
    /**
     * 商品编号
     */
    private String goodCode;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品状态
     */
    private String goodState;

    /**
     * 商品一级分类
     */
    private String goodFirstClass;

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

    public String getGoodState() {
        return goodState;
    }

    public void setGoodState(String goodState) {
        this.goodState = goodState;
    }

    public String getGoodFirstClass() {
        return goodFirstClass;
    }

    public void setGoodFirstClass(String goodFirstClass) {
        this.goodFirstClass = goodFirstClass;
    }

    public String getGoodSecClass() {
        return goodSecClass;
    }

    public void setGoodSecClass(String goodSecClass) {
        this.goodSecClass = goodSecClass;
    }
}
