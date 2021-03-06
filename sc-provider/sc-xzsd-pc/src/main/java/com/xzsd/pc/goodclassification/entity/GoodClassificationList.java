package com.xzsd.pc.goodclassification.entity;
import java.util.List;
/**
 * 商品分类列表查询二级联动所需实体类
 */
public class GoodClassificationList {
    /**
     *分类编号
     */
      private String classCode;
    /**
     *分类名字
     */
      private String className;
    /**
     *版本号
     */
      private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private List<GoodClassificationSon> listGoodClassificationSon;
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

    public List<GoodClassificationSon> getListGoodClassificationSon() {
        return listGoodClassificationSon;
    }

    public void setListGoodClassificationSon(List<GoodClassificationSon> listGoodClassificationSon) {
        this.listGoodClassificationSon = listGoodClassificationSon;
    }
}
