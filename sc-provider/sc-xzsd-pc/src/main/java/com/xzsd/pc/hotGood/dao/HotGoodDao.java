package com.xzsd.pc.hotGood.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xzsd.pc.hotGood.entity.*;

import java.util.List;


/**
 * 热门商品位Dao
 * zhc
 * 2020年4月5日23:15:54
 */
@Mapper
public interface HotGoodDao {
    /**
     * 判断商品是否重复位排序
     * @param sort
     * @param hotGoodCode
     * @return
     */
    int countSort(@Param("hotGoodSort") int sort,@Param("hotGoodCode")String hotGoodCode);
    /**
     * 增加热门商品
     * @param hotGood
     * @return
     */
    int addHotGood(HotGood hotGood);

    /**
     * 判断商品是否已经被选择
     * @param goodCode
     * @return
     */
    int countGoodIsSelecter(@Param("goodCode")String goodCode,@Param("hotGoodCode")String hotGoodCode);
    /**
     * 热门商品位新增之商品列表查询
     * @param goodName
     * @param goodCode
     * @return
     */
    List<HotGoodQuery> queryGoodsList(@Param("goodName") String goodName, @Param("goodCode") String goodCode);

    /**
     *  热门商品位修改
     * @param hotGood
     * @return
     */
    int updateHotGood(HotGood hotGood);

    /**
     * 热门商品位删除
     * @param stringList
     * @param user
     * @return
     */
    int deleteHotGood(@Param("listHotCodes") List<String> stringList, @Param("updateUser") String user);

    /**
     * 热门商品位展示数量
     * @param showNum
     * @return
     */
    int showHotGoodsNum(ShowNum showNum);


    /**
     * 热门商品位列表查询
     * @return
     */
    List<HotGoodList>queryHotGoodsList(HotGoodList hotGoodList);

    /**
     * 热门商品位详情
     * @param code
     * @return
     */
    HotGoodDetail queryHotGoodDetail(@Param("hotGoodCode") String code);

    /**
     * 查询当前展示数量
     * @return
     */
    HotGoodNum queryGoodNum();
}
