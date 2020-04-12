package com.xzsd.app.homepage.entity;

/**
 * @Deprecated 热门商品列表实体类
 * @author  zhc
 * @Time 2020年4月10日11:57:41
 */
public class HotGoods {
    /**
     *热门商品编号
     */
    private String hotGoodCode;
    /**
     *热门商品名称
     */
    private String hotGoodName;
    /**
     *热门商品图片
     */
    private String hotGoodUrl;
    /**
     *热门商品位排序
     */
    private String hotGoodCSort;
    /**
     *热门商品原价
     */
    private String hotGoodPric;
    /**
     *热门商品售价
     */
    private String hotGoodSale;

    public String getHotGoodCode() {
        return hotGoodCode;
    }

    public void setHotGoodCode(String hotGoodCode) {
        this.hotGoodCode = hotGoodCode;
    }

    public String getHotGoodName() {
        return hotGoodName;
    }

    public void setHotGoodName(String hotGoodName) {
        this.hotGoodName = hotGoodName;
    }

    public String getHotGoodUrl() {
        return hotGoodUrl;
    }

    public void setHotGoodUrl(String hotGoodUrl) {
        this.hotGoodUrl = hotGoodUrl;
    }

    public String getHotGoodCSort() {
        return hotGoodCSort;
    }

    public void setHotGoodCSort(String hotGoodCSort) {
        this.hotGoodCSort = hotGoodCSort;
    }

    public String getHotGoodPric() {
        return hotGoodPric;
    }

    public void setHotGoodPric(String hotGoodPric) {
        this.hotGoodPric = hotGoodPric;
    }

    public String getHotGoodSale() {
        return hotGoodSale;
    }

    public void setHotGoodSale(String hotGoodSale) {
        this.hotGoodSale = hotGoodSale;
    }
}
