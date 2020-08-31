package com.xzsd.pc.user.entity;
public class AdminData {
    /**
     *用户编号
     */
    private String userCode;
    /**
     *用户角色
     */
    private int userRole;
    /**
     *用户账号
     */
    private String userAcc;
    /**
     *用户头像地址
     */
    private String userImageUrl;
    /**
     *用户姓名
     */
    private String userName;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
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
