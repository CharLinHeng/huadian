package com.xzsd.app.order.entity;
/**
 *商品过期实体类
 */
public class GoodsExpired {
    /**
     * 购物车编号
     */
    private String cartCode;

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    @Override
    public String toString() {
        return "GoodsExpired{" +
                "cartCode='" + cartCode + '\'' +
                '}';
    }
}
