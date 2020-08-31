package com.xzsd.pc.store.entity;

/**
 * 新增门店的实体类
 */
public class Store {
    /**
     * 编号
     */
    private String storeCode;
    /**
     * 门店名称
     *
     */
    private String storeName;
    /**
     * 联系电话
     *
     */
    private String storePhone;
    /**
     * 店长编号
     *
     */
    private String userCode;
    /**
     * * 营业执照
     *
     */
    private String storeBusinessLicense;
    /**
     * * 省编号
     */
    private String storeProvinceCode;
    /**
     *   市编号
     */
    private String storeCityCode;
    /**
     *  区编号
     */
    private String storeDistinctCode;
    /**
     *  详细地址
     */
    private String storeDetailAddress;
    /**
     * 门店邀请码
     */
    private String investCode;
    /**
     * 修改用户
     */
    private String updateUser;
    /**
     * 版本号
     */
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getInvestCode() {
        return investCode;
    }

    public void setInvestCode(String investCode) {
        this.investCode = investCode;
    }

    private String udateUser;

    public String getUdateUser() {
        return udateUser;
    }

    public void setUdateUser(String udateUser) {
        this.udateUser = udateUser;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStoreBusinessLicense() {
        return storeBusinessLicense;
    }

    public void setStoreBusinessLicense(String storeBusinessLicense) {
        this.storeBusinessLicense = storeBusinessLicense;
    }

    public String getStoreProvinceCode() {
        return storeProvinceCode;
    }

    public void setStoreProvinceCode(String storeProvinceCode) {
        this.storeProvinceCode = storeProvinceCode;
    }

    public String getStoreCityCode() {
        return storeCityCode;
    }

    public void setStoreCityCode(String storeCityCode) {
        this.storeCityCode = storeCityCode;
    }

    public String getStoreDistinctCode() {
        return storeDistinctCode;
    }

    public void setStoreDistinctCode(String storeDistinctCode) {
        this.storeDistinctCode = storeDistinctCode;
    }

    public String getStoreDetailAddress() {
        return storeDetailAddress;
    }

    public void setStoreDetailAddress(String storeDetailAddress) {
        this.storeDetailAddress = storeDetailAddress;
    }
}
