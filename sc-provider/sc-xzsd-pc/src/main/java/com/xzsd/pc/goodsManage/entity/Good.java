package com.xzsd.pc.goodsManage.entity;


/**
 * 商品实体
 * author:zhc
 * time: 2020年3月25日15:25:15
 */
public class Good {
    /**
     * 货物编号
     */
    private String good_code;

    /**
     * 货物名称
     */
    private String good_name;

    /**
     * 商品价格
     */
    private double good_price;

    /**
     * 商品销售价格
     */
    private double good_selling_price;

    /**
     * 商品销售的数量
     */
    private int good_saleNum;

    /**
     * 商品一级分类
     */
    private String good_first_clas;
    /**
     * 商品二级分类
     */
    private String good_second_clas;

    /**
     * 商品广告
     */
    private String good_ad;
    /**
     * 商品描述
     */
    private String good_prec;
    /**
     * 商品状态
     */
    private int good_state;
    /**
     * 商品销售时间
     */
    private String good_sale_time;
    /**
     * 商品下架时间
     */
    private String good_sale_end;
    /**
     * 商品评价等级
     */
    private double good_eva_rank;
    /**
     * 商品浏览量
     */
    private int good_through_num;
    /**
     * 商品库存
     */
    private int good_lib_save;
    /**
     * 商品作者
     */
    private String good_author;
    /**
     * 商品出版社
     */
    private  String good_commodity_press;
    /**
     * 商品书号
     */
    private String good_isbn_bookSize;
    /**
     * 商品图片地址
     */
    private String good_image_url;

    /**
     * 商品是否弃用
     */
    private int is_delete;
    /**
     * 页分页号
     */
    private int pageSize;
    /**
     * 分页数量
     */
    private int pageNum;

    /**
     * 商品创建用户
     *
     */
    private String create_user;
    /**
     * 商品更新用户
     */
    private String update_user;

    public String getGood_code() {
        return good_code;
    }

    public void setGood_code(String good_code) {
        this.good_code = good_code;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }

    public double getGood_selling_price() {
        return good_selling_price;
    }

    public void setGood_selling_price(double good_selling_price) {
        this.good_selling_price = good_selling_price;
    }

    public int getGood_saleNum() {
        return good_saleNum;
    }

    public void setGood_saleNum(int good_saleNum) {
        this.good_saleNum = good_saleNum;
    }

    public String getGood_first_clas() {
        return good_first_clas;
    }

    public void setGood_first_clas(String good_first_clas) {
        this.good_first_clas = good_first_clas;
    }

    public String getGood_second_clas() {
        return good_second_clas;
    }

    public void setGood_second_clas(String good_second_clas) {
        this.good_second_clas = good_second_clas;
    }

    public String getGood_ad() {
        return good_ad;
    }

    public void setGood_ad(String good_ad) {
        this.good_ad = good_ad;
    }

    public String getGood_prec() {
        return good_prec;
    }

    public void setGood_prec(String good_prec) {
        this.good_prec = good_prec;
    }

    public int getGood_state() {
        return good_state;
    }

    public void setGood_state(int good_state) {
        this.good_state = good_state;
    }

    public String getGood_sale_time() {
        return good_sale_time;
    }

    public void setGood_sale_time(String good_sale_time) {
        this.good_sale_time = good_sale_time;
    }

    public String getGood_sale_end() {
        return good_sale_end;
    }

    public void setGood_sale_end(String good_sale_end) {
        this.good_sale_end = good_sale_end;
    }

    public double getGood_eva_rank() {
        return good_eva_rank;
    }

    public void setGood_eva_rank(double good_eva_rank) {
        this.good_eva_rank = good_eva_rank;
    }

    public int getGood_through_num() {
        return good_through_num;
    }

    public void setGood_through_num(int good_through_num) {
        this.good_through_num = good_through_num;
    }

    public int getGood_lib_save() {
        return good_lib_save;
    }

    public void setGood_lib_save(int good_lib_save) {
        this.good_lib_save = good_lib_save;
    }

    public String getGood_author() {
        return good_author;
    }

    public void setGood_author(String good_author) {
        this.good_author = good_author;
    }

    public String getGood_commodity_press() {
        return good_commodity_press;
    }

    public void setGood_commodity_press(String good_commodity_press) {
        this.good_commodity_press = good_commodity_press;
    }

    public String getGood_isbn_bookSize() {
        return good_isbn_bookSize;
    }

    public void setGood_isbn_bookSize(String good_isbn_bookSize) {
        this.good_isbn_bookSize = good_isbn_bookSize;
    }

    public String getGood_image_url() {
        return good_image_url;
    }

    public void setGood_image_url(String good_image_url) {
        this.good_image_url = good_image_url;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
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

    @Override
    public String toString() {
        return "Good{" +
                "good_code='" + good_code + '\'' +
                ", good_name='" + good_name + '\'' +
                ", good_price=" + good_price +
                ", good_selling_price=" + good_selling_price +
                ", good_saleNum=" + good_saleNum +
                ", good_first_clas='" + good_first_clas + '\'' +
                ", good_second_clas='" + good_second_clas + '\'' +
                ", good_ad='" + good_ad + '\'' +
                ", good_prec='" + good_prec + '\'' +
                ", good_state=" + good_state +
                ", good_sale_time='" + good_sale_time + '\'' +
                ", good_sale_end='" + good_sale_end + '\'' +
                ", good_eva_rank=" + good_eva_rank +
                ", good_through_num=" + good_through_num +
                ", good_lib_save=" + good_lib_save +
                ", good_author='" + good_author + '\'' +
                ", good_commodity_press='" + good_commodity_press + '\'' +
                ", good_isbn_bookSize='" + good_isbn_bookSize + '\'' +
                ", good_image_url='" + good_image_url + '\'' +
                ", is_delete=" + is_delete +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", create_user='" + create_user + '\'' +
                ", update_user='" + update_user + '\'' +
                '}';
    }
}
