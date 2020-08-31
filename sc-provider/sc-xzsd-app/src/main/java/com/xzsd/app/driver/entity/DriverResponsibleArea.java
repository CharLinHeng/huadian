package com.xzsd.app.driver.entity;

/**
 * 司机负责区域实体类 - 参数
 */
public class DriverResponsibleArea {
    /**
     *司机编号
     */
    private String driverCode;
    /**
     * 省编号
     */
    private String provinceCode;
    /**
     *市区编号
     */
    private String cityCode;
    /**
     *区编号
     */
    private String distinctCode;
    /**
     *详细地址
     */
    private String detailAddress;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 店长姓名
     */
    private String userName;
    /**
     * 店长手机
     */
    private String userPhone;
    /**
     * 门店编号
     */
    private String storeCode;

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
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

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
