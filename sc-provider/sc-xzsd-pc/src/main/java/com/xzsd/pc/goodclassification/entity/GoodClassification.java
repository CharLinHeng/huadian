package com.xzsd.pc.goodclassification.entity;

/**
 * 商品分类实体列
 */
public class GoodClassification {
    /**
     * 分类编号
     */
    private String classCode;
    /**
     * 分类名称
     */
    private String className;
    /**
     * 分类等级
     */
    private String classRank;
    /**
     * 所属一级分类 编号
     */
        private String firstClassCode;
    /**
     * 分类标记
     */
    private String classRemark;
    /**
     * 创建作者
     */
    private String createUser;
    /**
     * 更新者
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

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String clasCode) {
        this.classCode = clasCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassRank() {
        return classRank;
    }

    public void setClassRank(String classRank) {
        this.classRank = classRank;
    }

    public String getFirstClassCode() {
        return firstClassCode;
    }

    public void setFirstClassCode(String firstClassCode) {
        this.firstClassCode = firstClassCode;
    }

    public String getClassRemark() {
        return classRemark;
    }

    public void setClassRemark(String classRemark) {
        this.classRemark = classRemark;
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
