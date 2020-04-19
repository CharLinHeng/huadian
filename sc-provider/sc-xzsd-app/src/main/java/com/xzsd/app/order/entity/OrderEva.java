package com.xzsd.app.order.entity;

import java.util.List;

/**
 * 增加订单商品评价
 */
public class OrderEva {
    /**
     * 订单编号
     */
   private String orderCode;
    /**
     * 当前用户编号
     */
   private String userCode;
    /**
     * 评价集合
     */
   private List<OrderEvaUnit> evaList;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<OrderEvaUnit> getEvaList() {
        return evaList;
    }

    public void setEvaList(List<OrderEvaUnit> evaList) {
        this.evaList = evaList;
    }
}
