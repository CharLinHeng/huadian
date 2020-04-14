package com.xzsd.app.order.entity;

/**
 * 新增顾客实体类
 */
public class Customer {
    /**
     * 顾客编号
     */
    private String customerCode;
    /**
     * 商店编号
     */
    private String shopCode;
    /**
     *用户编号
     */
    private String userCode;
    /**
     *顾客订单
     */
    private String customerOrder;
    /**
     *顾客名字
     */
    private String customerName;
    /**
     *顾客账号
     */
    private String customerAcct;
    /**
     *顾客性别
     */
    private String customerSex;
    /**
     *顾客手机号
     */
    private String customerPhone;
    /**
     *顾客邮箱
     */
    private String customerEmail;
    /**
     * 身份证
     */
    private String customerIdCard;

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(String customerOrder) {
        this.customerOrder = customerOrder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAcct() {
        return customerAcct;
    }

    public void setCustomerAcct(String customerAcct) {
        this.customerAcct = customerAcct;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode='" + customerCode + '\'' +
                ", shopCode='" + shopCode + '\'' +
                ", userCode='" + userCode + '\'' +
                ", customerOrder='" + customerOrder + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAcct='" + customerAcct + '\'' +
                ", customerSex='" + customerSex + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerIdCard='" + customerIdCard + '\'' +
                '}';
    }
}
