package com.xzsd.app.goodClassification.entity;
/**
 * 商品分类实体类
 */
public class GoodClassification {
    /**
     * 分类编号
     */
    private String classCode;
    /**
     *分类名称
     */
    private String className;

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
}
