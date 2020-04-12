package com.xzsd.app.shoppingCart.entity;

/**
 * 增加购物车商品实体类
 */
public class AddShoppingCart {
    /**
     * 购物车编号
     */
    private String cartCode;
    /**
     *用户编号
     */
    private String userCode;
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     * 商品数量
     */
    private int goodsNum;

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }
}
