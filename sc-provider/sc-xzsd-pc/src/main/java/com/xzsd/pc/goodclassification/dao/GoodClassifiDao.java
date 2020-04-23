package com.xzsd.pc.goodclassification.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xzsd.pc.goodclassification.entity.GoodClassification;

import java.util.List;

/**
 *商品分类管理Dao
 * zhc
 * 2020年4月4日14:28:31
 */
@Mapper

public interface GoodClassifiDao {
    /**
     * 商品一级分类新增
     * @param goodClassification
     * @return
     */
    int addFirstClass(GoodClassification goodClassification);

    /**
     * 计数名称
     * @param className
     * @return
     */
    int countClassName(@Param("className") String className,@Param("classCode")String code);

    /**
     * 商品二级分类新增
     * @param goodClassification
     * @return
     */
    int addSecondClass(GoodClassification goodClassification);

    /**
     * 商品分类修改
     * @param goodClassification
     * @return
     */
    int updateGoodClass(GoodClassification goodClassification);

    /**
     * 商品分类删除\
     * @param codes
     * @param updateUser
     * @return
     */
    int deleteGoodClass(@Param("classCodeList") List<String> codes, @Param("updateUser") String updateUser);

    /**
     * 判断一级分类附属的二级分类数量
     * @param code
     * @return
     */
    int countOneBelongSecondClassNum(@Param("classCode") String code);

    /**
     * 判断二级分类下面是否还有商品，不然不能够删除
     * @param secondCode
     * @return
     */
    int countSecondClassBelongGood(@Param("classCode") String secondCode);

    /**
     * 商品分类详情查询
     * @param code
     * @return
     */
    GoodClassification queryGoodClass(@Param("classCode") String code);


    /**
     * 商品分类列表查询
     * @return
     */
    List<GoodClassification> queryGoodClassList();
}
