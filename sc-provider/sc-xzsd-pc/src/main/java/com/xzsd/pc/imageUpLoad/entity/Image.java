package com.xzsd.pc.imageUpLoad.entity;

public class Image {
    /**
     * 上传时间
     */
    private String uploadTime;
    /**
     *访问地址
     */
    private String imageUrl;

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
