package com.xzsd.app.driver.entity;

public class AreaName {
    /**
     * 省名称
     */
    private String ProvinceName;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区名称
     */
    private String distinctName;
    /**
     * 详细地址
     */
    private String detailAddress;

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistinctName() {
        return distinctName;
    }

    public void setDistinctName(String distinctName) {
        this.distinctName = distinctName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
