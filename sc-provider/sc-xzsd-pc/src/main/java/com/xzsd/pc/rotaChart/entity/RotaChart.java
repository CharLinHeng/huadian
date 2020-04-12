package com.xzsd.pc.rotaChart.entity;

public class RotaChart {
    /**
     * 轮播图编号
     */
    private String rotaChartCode;

    /**
     * 轮播图状态
     */
    private int rotaChartState;

    /**
     * 轮播图标题
     */
    private String rotaChartTitle;

    /**
     * 轮播图位排序
     */
    private int rotaChartSort;

    /**
     * 轮播图附加描述
     */
    private String rotaChartAdditionPre;

    /**
     * 轮播图启用时间
     */
    private String rotaChartStartTime;

    /**
     * 轮播图结束时间
     */
    private String rotaChartEndTime;

    /**
     * 轮播图商品编号
     */
    private String goodCode;

    /**
     * 轮播图创建时间
     */
    private String createTime;

    /**
     * 轮播图创建用户
     */
    private String createUser;

    /**
     * 轮播图更新时间
     */
    private String updateTime;

    /**
     * 轮播图更新用户
     */
    private String updateUser;

    /**
     * 轮播图是否弃用
     */
    private String isDelete;

    /**
     * 轮播图版本号
     */
    private String version;
    /**
     * 一页显示多少
     */
    private int pageSize;
    /**
     * 页号数
     */
    private int pageNum;

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

    public String getRotaChartCode() {
        return rotaChartCode;
    }

    public void setRotaChartCode(String rotaChartCode) {
        this.rotaChartCode = rotaChartCode;
    }

    public int getRotaChartState() {
        return rotaChartState;
    }

    public void setRotaChartState(int rotaChartState) {
        this.rotaChartState = rotaChartState;
    }

    public String getRotaChartTitle() {
        return rotaChartTitle;
    }

    public void setRotaChartTitle(String rotaChartTitle) {
        this.rotaChartTitle = rotaChartTitle;
    }

    public int getRotaChartSort() {
        return rotaChartSort;
    }

    public String getRotaChartAdditionPre() {
        return rotaChartAdditionPre;
    }

    public void setRotaChartAdditionPre(String rotaChartAdditionPre) {
        this.rotaChartAdditionPre = rotaChartAdditionPre;
    }

    public String getRotaChartStartTime() {
        return rotaChartStartTime;
    }

    public void setRotaChartStartTime(String rotaChartStartTime) {
        this.rotaChartStartTime = rotaChartStartTime;
    }

    public void setRotaChartSort(int rotaChartSort) {

        this.rotaChartSort = rotaChartSort;
    }

    public String getRotaChartEndTime() {
        return rotaChartEndTime;
    }

    public void setRotaChartEndTime(String rotaChartEndTime) {
        this.rotaChartEndTime = rotaChartEndTime;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
