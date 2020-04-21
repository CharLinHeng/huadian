package com.xzsd.app.storeInvest.entity;

/**
 * 新增门店绑定实体类
 */
public class BindStore {
    /**
     *板顶编号
     */
    private String bindCode;
    /**
     *商家编号
     */
    private String shopCode;
    /**
     *用户编号
     */
    private String userCode;
    /**
     *绑定邀请码
     */
    private String bindInverstCode;
    /**
     *创建用户
     */
    private String createUser;
    /**
     *更新用户
     */
    private String updateUser;

    public String getBindCode() {
        return bindCode;
    }

    public void setBindCode(String bindCode) {
        this.bindCode = bindCode;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getBindInverstCode() {
        return bindInverstCode;
    }

    public void setBindInverstCode(String bindInverstCode) {
        this.bindInverstCode = bindInverstCode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
