package com.xzsd.pc.store.entity;

/**
 * 新增门店之 商家列表查询 实体类
 */
public class QueryUserStore {
    /**
     *用户编号
     */
    private String userCode;
    /**
     *用户账号
     */
    private String userAccount;
    /**
     *用户名字
     */
    private String userName;
    /**
     *用户手机号
     */
    private String userPhone;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
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
}
