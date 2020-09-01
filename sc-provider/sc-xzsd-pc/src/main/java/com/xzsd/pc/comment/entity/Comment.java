package com.xzsd.pc.comment.entity;

/**
 * 商品评价实体类
 */
public class Comment {
    /**
     *评价编号
     */
    private String evaCode;
    /**
     *评价星级
     */
    private String evaRank;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     *评价用户名称
     */
    private String evaUserName;
    /**
     *评价者评论
     */
    private String evaContent;
    /**
     *评价物品
     */
    private String evaGoods;
    /**
     *评价时间
     */
    private String evaTime;
    /**
     *结束时间
     */
    private String timeEnd;
    /**
     *开始时间
     */
    private String timeStart;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 版本号
     */
    private String version;
    /**
     * 页号
     */
    private int pageNum;
    /**
     * 页数量
     */
    private int pageSize;

    public String getEvaGoods() {
        return evaGoods;
    }

    public void setEvaGoods(String evaGoods) {
        this.evaGoods = evaGoods;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getEvaCode() {
        return evaCode;
    }

    public void setEvaCode(String evaCode) {
        this.evaCode = evaCode;
    }

    public String getEvaRank() {
        return evaRank;
    }

    public void setEvaRank(String evaRank) {
        this.evaRank = evaRank;
    }

    public String getEvaUserName() {
        return evaUserName;
    }

    public void setEvaUserName(String evaUserName) {
        this.evaUserName = evaUserName;
    }

    public String getEvaContent() {
        return evaContent;
    }

    public void setEvaContent(String evaContent) {
        this.evaContent = evaContent;
    }

    public String getEvaTime() {
        return evaTime;
    }

    public void setEvaTime(String evaTime) {
        this.evaTime = evaTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "evaCode='" + evaCode + '\'' +
                ", evaRank='" + evaRank + '\'' +
                ", evaUserName='" + evaUserName + '\'' +
                ", evaContent='" + evaContent + '\'' +
                ", evaTime='" + evaTime + '\'' +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", version='" + version + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
