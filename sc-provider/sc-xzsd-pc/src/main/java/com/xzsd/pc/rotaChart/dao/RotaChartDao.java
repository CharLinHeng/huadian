package com.xzsd.pc.rotaChart.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xzsd.pc.goods.entity.Good;
import com.xzsd.pc.rotaChart.entity.RotaChart;

import java.util.List;

/**
 * 轮播图
 * 2020年3月27日14:30:12
 *
 */
@Mapper
public interface RotaChartDao {
    /**
     * 查询是否重复
     * @param sort
     * @param goodCode
     * @param rotaChartCode
     * @return
     */
    int countRepeat(@Param("rotaChartSort")int sort,@Param("goodCode")String goodCode,@Param("rotaChartCode")String rotaChartCode);
    /**
     * 轮播图新增
     * @param rotaChart
     * @return
     */
    int addRotaChart(RotaChart rotaChart);
    /**
     * 删除轮播图
     * @param listCode
     * @param user
     * @return
     */
    int deleteRotaChart(@Param("listRotaChartCodes") List<String> listCode, @Param("update_user") String user);
    /**
     * 轮播图列表查询
     * @param rotaChartState
     * @return
     */
    List<RotaChart> queryRotaChartList(RotaChart rotaChartState);


    /**
     * 轮播图启用禁用修改
     * @param rotaChartStateCodes
     * @param rotaChartState
     * @return
     */
    int updateRotaChartState(@Param("list") List<String> rotaChartStateCodes, @Param("rotaChartState") int rotaChartState);


    /**
     * 轮播图新增之 商品编号列表查询
     * @param good
     * @return
     */
    List<Good>querylistGoods2(Good good);



}
