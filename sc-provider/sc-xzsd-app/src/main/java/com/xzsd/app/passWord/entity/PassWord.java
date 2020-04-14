package com.xzsd.app.passWord.entity;
/**
 * 注册实体类
 */
public class PassWord {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户输入的原密码
     */
    private String userPass;
    /**
     * 输入的密码
     */
    private String cinPass;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getCinPass() {
        return cinPass;
    }

    public void setCinPass(String cinPass) {
        this.cinPass = cinPass;
    }
}
