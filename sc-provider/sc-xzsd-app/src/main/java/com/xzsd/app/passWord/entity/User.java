package com.xzsd.app.passWord.entity;
/**
 *用户实体类
 */
public class User {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户角色
     */
    private int userRole;

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

    @Override
    public String toString() {
        return "User{" +
                "userCode='" + userCode + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
