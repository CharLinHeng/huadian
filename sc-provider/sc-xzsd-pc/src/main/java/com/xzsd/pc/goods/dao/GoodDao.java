package com.xzsd.pc.goodsManage.dao;


import com.xzsd.pc.goodsManage.entity.GoodList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xzsd.pc.goodsManage.entity.Good;

import java.util.List;

@Mapper
/**
 * 商品dao
 * zhc
 * 2020年3月25日16:12:53
 */
public interface GoodDao {
    /**
    *查询商品名称是否存在
     */
    int countGood(@Param("good_name") String good_name);
    /**
     * 查询商品书号是否存在
     *
     */
    int countGoodBookSize(@Param("good_isbn_bookSize") String bookSize);
    /**
     *查询商品详情
     */
    Good queryDetail(Good good);
    /**
     *新增商品
     */
    int addGood(Good good);
    /**
     *修改商品
     */
    int updateGood(Good good);
    /**
     *删除商品
     */
    int deleteGoods(@Param("listGoodCode") List<String> goodCodes, @Param("update_user") String update_user);
    /**
     *商品列表查询
     */
    List<GoodList> queryGoodList(Good good);
    /**
     *商品一级分类查询
     */

    /**
     *商品二级分类
     */

    /**
     *商品上架下架修改
     */
      int updateGoodState(@Param("listGoodCode") List<String> goodCodes, @Param("update_user") String updateUser, @Param("good_state") int good_state);


    /**
     * 消息队列 增加消息到数据库
     */
//    int insertToActiveMq(QueueEntity queueEntity);
}
