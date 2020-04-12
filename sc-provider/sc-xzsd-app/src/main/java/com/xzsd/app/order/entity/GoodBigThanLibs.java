package com.xzsd.app.order.entity;

/**
 * 存  商品编号，就是 某种商品的库存 小于 购物车中这种商品数量的商品编号
 */
public class GoodBigThanLibs {
    //商品编号
    private String goodCode;

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }
}
