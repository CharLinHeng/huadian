package com.xzsd.app.goodDetail.entity;

/**
 * 客户绑定店铺查询-临时实体类
 */
public class UserBindStore {
    /**
     * 门店名称
     */
    private String storeName;
    /**
     *门店地址
     */
    private String storeAddress;
    /**
     *门店编号
     */
    private String provinceCode;
    /**
     *市编号
     */
    private String cityCode;
    /**
     *区编号
     */
    private String distinctCode;
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistinctCode() {
        return distinctCode;
    }

    public void setDistinctCode(String distinctCode) {
        this.distinctCode = distinctCode;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}
