package com.xzsd.app.goodClassification.entity;

import java.util.List;

/**
 * 二级分类实体-app端
 */
public class GoodClassiSecond {

    /**
     * 分类编号
     */
    private String classCode;

    /**
     * 分类名称
     */
    private String className;
    /**
     * 二级分类对应的实体
     */
    List<Good> goodsList;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Good> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Good> goodsList) {
        this.goodsList = goodsList;
    }
}
