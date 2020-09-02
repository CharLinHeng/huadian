package com.xzsd.app.address.entity;

public class Address {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 收款人名字
     */
    private String userName;
    /**
     * 地址详情
     */
    private String addressDetail;
    /**
     * 地址编号
     */
    private String addressCode;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 修改人
     */
    private String updateUser;
    /**
     * 删除
     */
    private String isDelete;
    /**
     * 版本号
     */
    private String version;
    /**
     * 手机号码
     */
    private String userPhone;
    /**
     * 页面总数
     */
    private int PageNum;
    /**
     * 页面条数
     */
    private int PageSize;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Address{" +
                "userCode='" + userCode + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", addressCode='" + addressCode + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
