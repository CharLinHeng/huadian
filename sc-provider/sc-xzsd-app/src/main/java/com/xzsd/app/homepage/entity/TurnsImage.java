package com.xzsd.app.homepage.entity;
/**
 * @Deprecated  首页轮播图列表实体类
 * @author zhc
 * @time 2020年4月10日11:58:32
 */
public class TurnsImage {
    /**
     * 轮播图编号
     */
    private String rotateChartCode;
    /**
     * 轮播图位排序
     */
    private String rotateChartSort;
    /**
     * 轮播图图片地址
     */
    private String rotateChartImageUrl;
    /**
     * 商品编号
     */
    private String goodCode;

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getRotateChartCode() {
        return rotateChartCode;
    }

    public void setRotateChartCode(String rotateChartCode) {
        this.rotateChartCode = rotateChartCode;
    }

    public String getRotateChartSort() {
        return rotateChartSort;
    }

    public void setRotateChartSort(String rotateChartSort) {
        this.rotateChartSort = rotateChartSort;
    }

    public String getRotateChartImageUrl() {
        return rotateChartImageUrl;
    }

    public void setRotateChartImageUrl(String rotateChartImageUrl) {
        this.rotateChartImageUrl = rotateChartImageUrl;
    }
}
