package com.xzsd.app.shoppingCart.entity;

/**
 * 购物车 商品列表查询用户参数
 */
public class CartGoodUserParam {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     *页数量
     */
    private int pageSize;
    /**
     *页号
     */
    private int pageNum;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getPageSize() {
        return pageSize;
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
}
