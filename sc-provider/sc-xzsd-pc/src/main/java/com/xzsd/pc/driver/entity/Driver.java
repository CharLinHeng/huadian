package com.xzsd.pc.driver.entity;

public class Driver {
    /**
     * 司机编号
     */
    private String driverCode;

    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 司机账号
     */
    private String driverAcct;
    /**
     *司机手机
     */
    private String driverPhone;

    /**
     * 用户编号？
     */
    private String userCode;

    /**
     * 司机密码
     */
    private String driverPass;

    /**
     * 司机身份证
     */
    private String driverIdCard;

    /**
     * 司机身份名称
     */
    private String driverProvincCode;

    /**
     * 司机城市名称
     */
    private String driverCityCode;

    /**
     * 司机市区名称
     */
    private String driverDistinctCode;

    /**
     * 常见作者
     */
    private String createUser;


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

    public String getDriverAcct() {
        return driverAcct;
    }

    public void setDriverAcct(String driverAcct) {
        this.driverAcct = driverAcct;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDriverPass() {
        return driverPass;
    }

    public void setDriverPass(String driverPass) {
        this.driverPass = driverPass;
    }

    public String getDriverIdCard() {
        return driverIdCard;
    }

    public void setDriverIdCard(String driverIdCard) {
        this.driverIdCard = driverIdCard;
    }

    public String getDriverProvincCode() {
        return driverProvincCode;
    }

    public void setDriverProvincCode(String driverProvincCode) {
        this.driverProvincCode = driverProvincCode;
    }

    public String getDriverCityCode() {
        return driverCityCode;
    }

    public void setDriverCityCode(String driverCityCode) {
        this.driverCityCode = driverCityCode;
    }

    public String getDriverDistinctCode() {
        return driverDistinctCode;
    }

    public void setDriverDistinctCode(String driverDistinctCode) {
        this.driverDistinctCode = driverDistinctCode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverCode='" + driverCode + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverAcct='" + driverAcct + '\'' +
                ", driverPhone='" + driverPhone + '\'' +
                ", userCode='" + userCode + '\'' +
                ", driverPass='" + driverPass + '\'' +
                ", driverIdCard='" + driverIdCard + '\'' +
                ", driverProvincCode='" + driverProvincCode + '\'' +
                ", driverCityCode='" + driverCityCode + '\'' +
                ", driverDistinctCode='" + driverDistinctCode + '\'' +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}


