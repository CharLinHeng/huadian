package com.xzsd.app.goodDetail.entity;

/**
 * 客户绑定店铺查询-输出实体类
 */
public class UserBindData {
    private String storeName;
    private String storeAddress;

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
}
