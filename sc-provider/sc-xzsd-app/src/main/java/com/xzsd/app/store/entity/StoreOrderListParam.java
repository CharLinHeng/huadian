package com.xzsd.app.store.entity;

/**
 * 店长订单列表查询参数实体类
 */
public class StoreOrderListParam {
    /**
     *店长编号
     */
    private String userCode;
    /**
     *页号
     */
    private int pageNum;
    /**
     * 页显示数量
     */
    private int pageSize;
    /**
     * 订单编号
     */
    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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
