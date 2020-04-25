package com.xzsd.app.order.entity;

/**
 * 获取订单商品编号和 数量的实体类
 */
public class GetOrderGoodCodeAndNum {
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     *商品数量
     */
    private int goodNum;

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }
}
