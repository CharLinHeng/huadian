package com.xzsd.pc.rotaChart.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.rotaChart.entity.GoodList;
import com.xzsd.pc.util.*;
import org.springframework.stereotype.Service;
import com.xzsd.pc.goods.entity.Good;
import com.xzsd.pc.rotaChart.dao.RotaChartDao;
import com.xzsd.pc.rotaChart.entity.RotaChart;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.*;
/**
 * @Description 轮播图实现类
 * @author zhongehcheng
 * @date 2020-3-27
 */
@Service
public class RotService {
    @Resource
    private RotaChartDao rotaChartDao;
    private static final int DEFAULTUSE = 1;
    /**
     * 增加轮播图
     * @param rotaChart
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addRotaChart(RotaChart rotaChart){
        //判断轮播图图片地址
        if(null == rotaChart.getRotaChartImageUrl() || rotaChart.getRotaChartImageUrl() == ""){
            return AppResponse.paramError("轮播图图片地址参数缺失!");
        }
        if(rotaChart.getRotaChartSort() == 0){
            return AppResponse.paramError("轮播图位排序不能为0或者参数缺失!");
        }
        //判断商品编号
        if (null == rotaChart.getGoodCode() || rotaChart.getGoodCode() == "") {
            return AppResponse.paramError("轮播图选择的商品编号参数为空!");
        }
        //时间
        if(null == rotaChart.getRotaChartStartTime()|| null ==  rotaChart.getRotaChartEndTime()){
            return AppResponse.paramError("轮播图起始时间或者结束时间为空!");
        }
        if(rotaChart.getRotaChartStartTime() == ""|| rotaChart.getRotaChartEndTime() == ""){
            return AppResponse.paramError("轮播图起始时间或者结束时间为空!");
        }
        //判断轮播图是否已经被选择或者位排序已存在
        if(rotaChartDao.countRepeat(rotaChart.getRotaChartSort(),rotaChart.getGoodCode(),null) > 0){
            return AppResponse.paramError("轮播图选择的图片已经存在或者 位排序 已存在 !");
        }
        //设置默认是启用的
        rotaChart.setRotaChartState(DEFAULTUSE);
        //赋值操作用户
        rotaChart.setCreateUser(SecurityUtils.getCurrentUserUsername());
        int result = rotaChartDao.addRotaChart(rotaChart);
        if(result > 0 ){
            return AppResponse.success("新增成功!",result);
        }
        return AppResponse.paramError("新增失败!");
    }

    /**
     * 删除轮播图
     * @param rotaCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteRotaChart(RotaChart rotaCode){
        //判断
        if(null == rotaCode.getRotaChartCode() || rotaCode.getRotaChartCode() == ""){
            return AppResponse.paramError("轮播图编号为空!");
        }
        List<String> codelist = Arrays.asList(rotaCode.getRotaChartCode().split(","));
        int reuslt = rotaChartDao.deleteRotaChart(codelist,SecurityUtils.getCurrentUserUsername());
        if(reuslt > 0 ){
            return AppResponse.success("删除成功!",reuslt);
        }
        return AppResponse.paramError("删除失败!");
    }

    /**
     * 列表查询
     * @param rotaChart
     * @return
     */
    public AppResponse queryRotaChartList(RotaChart rotaChart){
        PageHelper.startPage(rotaChart.getPageNum(),rotaChart.getPageSize());
        List<RotaChart> rotaCharts = rotaChartDao.queryRotaChartList(rotaChart);
        PageInfo<RotaChart>data = new PageInfo<RotaChart>(rotaCharts);
        if(rotaCharts.size() > 0){
           return AppResponse.success("查询成功!",data);
        }
        return AppResponse.success("查询为空!");
    }

    /**
     * 轮播图启用禁用修改
     * @param rotaChartCode
     * @param state
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateRotaChartState(String rotaChartCode,String state){
        //如果参数不完整
        if(null == rotaChartCode || state  == "" || null == state){
            return AppResponse.paramError("参数不能为空!");
        }
        //查询
        List<String>codesList = Arrays.asList(rotaChartCode.split(","));
        //修改者
        int result = rotaChartDao.updateRotaChartState(codesList,Integer.parseInt(state),SecurityUtils.getCurrentUserUsername());
        if(result > 0){
            return AppResponse.success("修改成功",result);
        }
        return AppResponse.bizError("修改失败");
    }

    /**
     * 轮播图新增 商品编号列表查询
     * @param good
     * @return
     */
    public AppResponse querylistGoodsSecond(Good good){
        //查询参数是否为空
        //如果参数不完整
        if(good.getPageNum() == 0||good.getPageSize() == 0){
            return AppResponse.paramError("页号或者页数量不能为空!");
        }
        //查询数据列表
        PageHelper.startPage(good.getPageNum(),good.getPageSize());
        List<GoodList>goods = rotaChartDao.querylistGoodsSecond(good);
        PageInfo<GoodList>pageInfo = new PageInfo<>(goods);
        //返回判断
        if(goods.size() >0){
            return AppResponse.success("查询成功!",pageInfo);
        }
        return AppResponse.success("查询为空");
    }
}
