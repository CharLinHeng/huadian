package com.xzsd.pc.customerManage.entity;

public class Customer {
    /**
     * 顾客编号
     */
    private String customerCode;

    /**
     * 顾客名称
     */
    private String customerName;

    /**
     * 顾客账号
     */
    private String customerAcc;


    /**
     * 顾客性别
     */
    private String customerSex;

    /**
     * 顾客手机号
     */
    private String customerPhone;

    /**
     * 顾客邮箱
     */
    private String customerEmail;

    /**
     * 顾客身份证
     */
    private String customerIdCard;

    /**
     * 是否删除
     */
    private int is_delete;

    /**
     * 页号
     */
    private int pageNum;

    /**
     * 页数量
     */
    private int pageSize;

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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAcc() {
        return customerAcc;
    }

    public void setCustomerAcc(String customerAcc) {
        this.customerAcc = customerAcc;
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

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }
}
