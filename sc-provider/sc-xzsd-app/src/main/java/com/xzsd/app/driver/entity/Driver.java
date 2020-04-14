package com.xzsd.app.driver.entity;

/**
 * app-端- 司机信息实体类
 */
public class Driver {
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 司机编号
     */
    private String driverCode;

    /*
    司机名称
     */
    private String driverName;
    /**
     * 司机手机
     */
    private String driverPhone;

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

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
