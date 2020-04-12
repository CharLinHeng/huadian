package com.xzsd.app.homepage.dao;
import com.xzsd.app.homepage.entity.HotGoods;
import com.xzsd.app.homepage.entity.TurnsImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 首页Dao
 * zhc
 * 2020年4月10日11:56:00
 */
@Mapper
public interface HomePageDao {
    /**
     * 首页轮播图列表
     * @return
     */
    List<TurnsImage> queryRotateChartsList();

    /**
     * 首页热门商品列表
     * @return
     */
    List<HotGoods>queryHotGoodsList(@Param("num")int num);

    /**
     * 删除那些不在这list列表的轮播图
     * @param code
     * @return
     */
    int deleteOverdue(@Param("list")List<String>code);

    /**
     * 查询展示数量
     * @return
     */
    int queryNum();
}
