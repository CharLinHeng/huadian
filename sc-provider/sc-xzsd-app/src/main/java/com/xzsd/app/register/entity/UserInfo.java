package com.xzsd.app.register.entity;

public class UserInfo {
    /**
     *用户角色
     */
    private String userCode;
    /**
     *用户账号
     */
    private String userAcc;
    /**
     *用户角色
     */
    private int userRole;
    /**
     *用户头像
     */
    private String userImageUrl;
    /**
     *用户名字
     */
    private String userName;
    /**
     *用户昵称
     */
    private String usuerNickName;
    /**
     *用户手机号
     */
    private String userPhone;
    /**
     *用户性别
     */
    private int userSex;

    public String getUsuerNickName() {
        return usuerNickName;
    }

    public void setUsuerNickName(String usuerNickName) {
        this.usuerNickName = usuerNickName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
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

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
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
