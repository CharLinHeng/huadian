package com.xzsd.app.goodDetail.entity;

/**
 * 商品评价实体类
 */
public class GoodEva {
    /**
     *评价编号
     */
    private String evaCode;
    /**
     *评价星级
     */
    private String evaRank;
    /**
     *评价用户名称
     */
    private String evaUserName;
    /**
     * 评价用户头像
     */
    private String userImage;
    /**
     *评价者评论
     */
    private String evaContent;
    /**
     *评价时间
     */
    private String evaTime;
    /**
     * 评价图片
     */
    private String conmentImage;

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getConmentImage() {
        return conmentImage;
    }

    public void setConmentImage(String conmentImage) {
        this.conmentImage = conmentImage;
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
}
