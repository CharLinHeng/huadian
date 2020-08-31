package com.xzsd.pc.order.entity;
/**
 * 订单 实体类
 */
public class Order {
    /**
     * 编号
     */
   private String orderCode;
    /**
     * 订单总价格
     */
   private String orderCountPrice;
    /**
     * 订单状态
     */
   private String orderState;

    /**
     * 订单支付状态
     */
   private String orderPayState;

    /**
     * 订单描述
     */
   private String orderPre;

    /**
     * 订单确认支付时间
     */
   private String orderPayTime;
    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 下单人姓名
     */
    private String orderUserName;

    /**
     * 下单人手机号
     */
    private String orderUserPhone;

    /**
     * 订单是否删除
     */
    private String isDelete;

    /**
     * 版本号
     */
    private String version;
    //公司
    private String logisticsCompany;
    //快递单号
    private String logisticsCourierNumber;

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsCourierNumber() {
        return logisticsCourierNumber;
    }

    public void setLogisticsCourierNumber(String logisticsCourierNumber) {
        this.logisticsCourierNumber = logisticsCourierNumber;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderCountPrice() {
        return orderCountPrice;
    }

    public void setOrderCountPrice(String orderCountPrice) {
        this.orderCountPrice = orderCountPrice;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderPayState() {
        return orderPayState;
    }

    public void setOrderPayState(String orderPayState) {
        this.orderPayState = orderPayState;
    }

    public String getOrderPre() {
        return orderPre;
    }

    public void setOrderPre(String orderPre) {
        this.orderPre = orderPre;
    }

    public String getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(String orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getOrderUserPhone() {
        return orderUserPhone;
    }

    public void setOrderUserPhone(String orderUserPhone) {
        this.orderUserPhone = orderUserPhone;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
