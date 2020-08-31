package com.xzsd.pc.hotGood.entity;
/**
 * 热门商品详情实体类
 */
public class HotGoodDetail {
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     * 商品排序
     */
    private String hotGoodSort;
    /**
     * 商品版本号
     */
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getHotGoodSort() {
        return hotGoodSort;
    }

    public void setHotGoodSort(String hotGoodSort) {
        this.hotGoodSort = hotGoodSort;
    }
}
