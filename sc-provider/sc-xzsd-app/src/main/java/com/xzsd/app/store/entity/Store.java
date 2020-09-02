package com.xzsd.app.store.entity;

/**
 * <h3>Store</h3>
 * <p>门店</p>
 *
 * @author : CharLinHeng
 * @date : 2020-09-01 09:21
 **/
public class Store {
    private String shop_code;
    //门店营业执照
    private String shop_idCard;
    //门店名称
    private String shop_name;
    //
    private String shop_con_user;
    //门店电话
    private String shop_phone;
    //邮箱
    private String shop_email;
    //门店描述
    private String shop_desc;
    //省市区
    private String provinceCode;
    private String cityCode;
    private String distinctCode;
    //详细地址
    private String shop_detail_address;
    //
    private String create_user;
    private String update_user;
    //审核
    private String is_judge;
    public String getShop_code() {
        return shop_code;
    }

    public String getIs_judge() {
        return is_judge;
    }

    public void setIs_judge(String is_judge) {
        this.is_judge = is_judge;
    }

    public void setShop_code(String shop_code) {
        this.shop_code = shop_code;
    }

    public String getShop_idCard() {
        return shop_idCard;
    }

    public void setShop_idCard(String shop_idCard) {
        this.shop_idCard = shop_idCard;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_con_user() {
        return shop_con_user;
    }

    public void setShop_con_user(String shop_con_user) {
        this.shop_con_user = shop_con_user;
    }

    public String getShop_phone() {
        return shop_phone;
    }

    public void setShop_phone(String shop_phone) {
        this.shop_phone = shop_phone;
    }

    public String getShop_email() {
        return shop_email;
    }

    public void setShop_email(String shop_email) {
        this.shop_email = shop_email;
    }

    public String getShop_desc() {
        return shop_desc;
    }

    public void setShop_desc(String shop_desc) {
        this.shop_desc = shop_desc;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistinctCode() {
        return distinctCode;
    }

    public void setDistinctCode(String distinctCode) {
        this.distinctCode = distinctCode;
    }

    public String getShop_detail_address() {
        return shop_detail_address;
    }

    public void setShop_detail_address(String shop_detail_address) {
        this.shop_detail_address = shop_detail_address;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }
}
