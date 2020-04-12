package com.xzsd.app.goodDetail.entity;

/**
 * 查询参数实体类
 */
public class GoodEvaParam {
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     *商品评价等级
     */
    private int evaRank;
    /**
     * 页号
     */
    private int pageNum;
    /**
     * 页数量
     */
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public int getEvaRank() {
        return evaRank;
    }

    public void setEvaRank(int evaRank) {
        this.evaRank = evaRank;
    }
}
