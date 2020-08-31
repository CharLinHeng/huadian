package com.xzsd.pc.order.entity;

/**
 * 订单价格实体类
 */
public class OrderPrice {
    /**
     * 价格
     */
    private double price;
    /**
     * 数量
     */
    private int num;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
