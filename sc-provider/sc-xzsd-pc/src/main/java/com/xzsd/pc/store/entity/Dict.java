package com.xzsd.pc.storeManage.entity;

/**
 * 省市区实体
 */
public class Dict {
    /**
     * 地区编号
     */
    private String areaCode;

    /**
     * 地区名称
     */
    private String areaName;


    private String dictType;

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
