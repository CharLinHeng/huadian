package com.xzsd.app.goodClassification.dao;

import com.xzsd.app.goodClassification.entity.GoodClassiSecond;
import com.xzsd.app.goodClassification.entity.GoodClassification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodClassiDao {
    /**
     * 查询一级分类
     * @return
     */
    List<GoodClassification> queryOneClass();

    /**
     * 二级分类以及对应的商品
     * @param firstCode
     * @return
     */
    List<GoodClassiSecond>queryTwoClass(@Param("classCode")String firstCode);
}
