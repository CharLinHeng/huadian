package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.GoodClassifi;
import com.xzsd.pc.goods.entity.GoodList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xzsd.pc.goods.entity.Good;

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
    int countGood(@Param("goodName") String good_name,@Param("goodCode")String goodCode);
    /**
     * 查询商品书号是否存在
     *
     */
    int countGoodBookSize(@Param("goodIsbnBookSize") String bookSize,@Param("goodCode")String goodCode);
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
    int deleteGood(@Param("listGoodCode") List<String> goodCodes, @Param("updateUser") String update_user);
    /**
     *商品列表查询
     */
    List<GoodList> queryGoodList(Good good);
    /**
     *商品一级分类查询
     */
      List<GoodClassifi>queryFirstClass();
    /**
     *商品二级分类
     */
    List<GoodClassifi>querySecondClass(@Param("classCode")String classCode);
    /**
     *商品上架下架修改
     */
      int updateGoodState(@Param("listGoodCode") List<String> goodCodes, @Param("updateUser") String updateUser, @Param("goodState") int good_state);

    /**
     * 消息队列 增加消息到数据库
     */
//    int insertToActiveMq(QueueEntity queueEntity);

    /**
     * 删除商品对应的轮播图
     * @param listCodes
     * @return
     */
    int deleteTurns(@Param("list")List<String>listCodes);

    /**
     * 删除对应的热门商品
     * @param listCodes
     * @return
     */
    int deleteHotGoods(@Param("list")List<String>listCodes);

}
