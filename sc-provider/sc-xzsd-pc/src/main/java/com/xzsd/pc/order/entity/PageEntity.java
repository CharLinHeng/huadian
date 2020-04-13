package com.xzsd.pc.order.entity;


/**
 * 页号和页数、版本号
 */
public class PageEntity {
    private int pageSize;
    private int pageNum;

    private int version;
    private String orderCode;
    public int getPageSize() {
        return pageSize;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
