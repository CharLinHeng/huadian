package com.xzsd.app.driver.entity;

/**
 * 门店信息实体类
 */
public class Store {
    /**
     *门店编号
     */
    private String storeCode;
    /**
     *门店名称
     */
    private String storeName;
    /**
     *门店地址
     */
    private String storeAddress;
    /**
     *门店邀请码
     */
    private String storeInvitation;
    /**
     *店长编号
     */
    private String userCode;
    /**
     *店长头像
     */
    private String userImageUrl;
    /**
     *店长昵称
     */
    private String userName;

    private String is_judge;

    public String getIs_judge() {
        return is_judge;
    }

    public void setIs_judge(String is_judge) {
        this.is_judge = is_judge;
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

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreInvitation() {
        return storeInvitation;
    }

    public void setStoreInvitation(String storeInvitation) {
        this.storeInvitation = storeInvitation;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
