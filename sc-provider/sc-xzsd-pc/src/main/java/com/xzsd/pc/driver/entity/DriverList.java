package com.xzsd.pc.driver.entity;

public class DriverList {
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
     * 司机身份证
     */
    private String driverIdCard;

    /**
     * 页号
     */
    int pageNum;

    /**
     * 页号数量
     */
    int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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

    public String getDriverIdCard() {
        return driverIdCard;
    }

    public void setDriverIdCard(String driverIdCard) {
        this.driverIdCard = driverIdCard;
    }

}


