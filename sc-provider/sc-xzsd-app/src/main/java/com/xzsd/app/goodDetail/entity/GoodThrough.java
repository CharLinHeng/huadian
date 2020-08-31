package com.xzsd.app.goodDetail.entity;
/**
 * 商品浏览量实体类
 */
public class GoodThrough {
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     * 更新用户
     */
    private String updateUser;

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
