package com.xzsd.pc.hotGoodManage.entity;

public class HotGood {
    /**
     * 热门商品位编号
     */
    private String hotGoodCode;

    /**
     * 热门商品位描述
     */
    private String hotGoodPre;
    /**
     * 热门位商品未排序
     */
    private int hotGoodSort;
    /**
     * 热门绑定商品编号
     */
    private String goodCode;
    /**
     * 创建者
     */
    private String createUser;

    /**
     * 更新着
     */
    private String updateUser;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 版本号
     */
    private String version;

    public String getHotGoodCode() {
        return hotGoodCode;
    }

    public void setHotGoodCode(String hotGoodCode) {
        this.hotGoodCode = hotGoodCode;
    }

    public String getHotGoodPre() {
        return hotGoodPre;
    }

    public void setHotGoodPre(String hotGoodPre) {
        this.hotGoodPre = hotGoodPre;
    }

    public int getHotGoodSort() {
        return hotGoodSort;
    }

    public void setHotGoodSort(int hotGoodSort) {
        this.hotGoodSort = hotGoodSort;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
