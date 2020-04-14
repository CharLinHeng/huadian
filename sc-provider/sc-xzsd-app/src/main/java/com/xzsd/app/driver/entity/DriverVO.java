package com.xzsd.app.driver.entity;

/**
 * 司机信息详情实体类
 */
public class DriverVO {
    /**
     *司机编号
     */
    private String driverCode;
    /**
     *司机姓名
     */
    private String driverName;
    /**
     *司机手机
     */
    private String driverPhone;
    /**
     *司机头像
     */
    private String driverImageUrl;
    /**
     * 司机昵称
     */
    private String driverNickName;

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverImageUrl() {
        return driverImageUrl;
    }

    public void setDriverImageUrl(String driverImageUrl) {
        this.driverImageUrl = driverImageUrl;
    }

    public String getDriverNickName() {
        return driverNickName;
    }

    public void setDriverNickName(String driverNickName) {
        this.driverNickName = driverNickName;
    }
}
