package com.xzsd.pc.order.entity;

public class OrderQuery {
    /**
     *下单人名字
     */
    private String orderUserName;
    /**
     *订单编码
     */
    private String orderCode;
    /**
     *n	订单付款时间范围起始
     */
    private String orderPayTimeStart;
    /**
     *订单付款时间范围结束
     */
    private String orderPayTimeEnd;
    /**
     *手机号
     */
    private String orderUserPhone;
    /**
     *订单状态
     */
    private String orderState;
    /**
     *当前页是第几页
     */
    private int pageNum;
    /**
     *每页显示多少条
     */
    private int pageSize;
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

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderPayTimeStart() {
        return orderPayTimeStart;
    }

    public void setOrderPayTimeStart(String orderPayTimeStart) {
        this.orderPayTimeStart = orderPayTimeStart;
    }

    public String getOrderPayTimeEnd() {
        return orderPayTimeEnd;
    }

    public void setOrderPayTimeEnd(String orderPayTimeEnd) {
        this.orderPayTimeEnd = orderPayTimeEnd;
    }

    public String getOrderUserPhone() {
        return orderUserPhone;
    }

    public void setOrderUserPhone(String orderUserPhone) {
        this.orderUserPhone = orderUserPhone;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

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
}
