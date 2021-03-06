package com.xzsd.app.register.entity;
/**
 * 注册实体类
 */
public class Register {
    /**
     * 用户编号
     */
    private String userCode;



    /**
     * 用户账号
     */
    private String userAcc;

    /**
     * 用户密码
     */
    private String userPass;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户名字
     * 可选
     */
    private String userName;
    /**
     * 性别
     * 可选
     */
    private int userSex;
    /**
     * 身份证
     */
    private String userIdCard;

    /**
     * 可选
     * 邮箱
     */
    private String userEmail;
    /**
     * 图片头像
     */
    private String imagrUrl;
    /**
     * 用户角色
     */
    private String role;
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImagrUrl() {
        return imagrUrl;
    }

    public void setImagrUrl(String imagrUrl) {
        this.imagrUrl = imagrUrl;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
