package com.xzsd.pc.storeManage.entity;

public class StoreListQueryEntity {

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
     *  详细地址
     */
    private String storeAddress;

    /**
     *   * 店长姓名
     *      *
     */
    private String storeUserName;
    /**
     * 门店邀请码
     */
    private String storeinvitation;
    /**
     * 其实也就是用户账号
     */
    private String storeAcc;



    private String storeProvince;

    private String storeCity;

    private String storeDistinct;

    public String getStoreProvince() {
        return storeProvince;
    }

    public void setStoreProvince(String storeProvince) {
        this.storeProvince = storeProvince;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public String getStoreDistinct() {
        return storeDistinct;
    }

    public void setStoreDistinct(String storeDistinct) {
        this.storeDistinct = storeDistinct;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
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

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreUserName() {
        return storeUserName;
    }

    public void setStoreUserName(String storeUserName) {
        this.storeUserName = storeUserName;
    }

    public String getStoreinvitation() {
        return storeinvitation;
    }

    public void setStoreinvitation(String storeinvitation) {
        this.storeinvitation = storeinvitation;
    }

    public String getStoreAcc() {
        return storeAcc;
    }

    public void setStoreAcc(String storeAcc) {
        this.storeAcc = storeAcc;
    }
}
