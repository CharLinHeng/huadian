package com.xzsd.pc.rotaChart.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Service;
import com.xzsd.pc.goodsManage.entity.Good;
import com.xzsd.pc.rotaChart.dao.RotaChartDao;
import com.xzsd.pc.rotaChart.entity.RotaChart;
import com.xzsd.pc.util.ChangeBeMap;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;
import com.xzsd.pc.util.ResponceListData;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class RotService {
    private ResponceData responceData;
    @Resource
    private RotaChartDao rotaChartDao;
    /**
     * 增加轮播图
     * @param rotaChart
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addRotaChart(RotaChart rotaChart){
        //判断轮播图图片地址
        if(null == rotaChart.getRotaChartImageUrl() || rotaChart.getRotaChartImageUrl() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"轮播图图片地址参数缺失!",null);
        }
        int result = rotaChartDao.addRotaChart(rotaChart);
        if(result > 0 ){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"新增成功!",result);
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"新增失败!",result);
        }
        return responceData;
    }

    /**
     * 删除轮播图
     * @param rotaCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteRotaChart(RotaChart rotaCode){
        List<String> codelist = Arrays.asList(rotaCode.getRotaChartCode().split(","));
        int reuslt = rotaChartDao.deleteRotaChart(codelist,"administrator");
        if(reuslt > 0 ){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功!",reuslt);
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"删除失败!",reuslt);
        }
        return responceData;
    }

    /**
     * 列表查询
     * @param rotaChart
     * @return
     */
    public ResponceListData queryRotaChartList(RotaChart rotaChart){
        ResponceListData responceListData;
        //如果没有pageSize和pageNum，那么返回错误
        if(rotaChart.getPageNum() == 0||rotaChart.getPageSize() == 0){
            responceListData = new ResponceListData(ResponceDataState.values()[3].getCode(),"页号或者页数量不能为空!",0,0,
                    0,null);
            return responceListData;
        }
        PageHelper.startPage(rotaChart.getPageNum(),rotaChart.getPageSize());
        List<RotaChart> rotaCharts = rotaChartDao.queryRotaChartList(rotaChart);
        PageInfo<RotaChart>data = new PageInfo<RotaChart>(rotaCharts);
        List<Map<String,String>>mapList  =  new ArrayList<>();
        //往里加
        for(RotaChart rotaChart1 : rotaCharts){
            Map tempMap = ChangeBeMap.changeTtoMap(rotaChart1);
            mapList.add(tempMap);
        }
        //使用Map得到结果
        String result = "查询成功";
        if(rotaCharts.size() == 0){
            result = "查询为空！";
        }
        responceListData = new ResponceListData(ResponceDataState.values()[0].getCode(),result,data.getPageSize(),data.getPageNum(),
                (int)data.getTotal(),mapList);
        return responceListData;
    }

    /**
     * 轮播图启用禁用修改
     * @param rotaChartCode
     * @param state
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateRotaChartState(String rotaChartCode,String state){
        //如果参数不完整
        if(null == rotaChartCode || state.length() == 0){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"参数不能为空!",null);
            return responceData;
        }
        //查询
        List<String>codesList = Arrays.asList(rotaChartCode.split(","));
        int result = rotaChartDao.updateRotaChartState(codesList,Integer.parseInt(state));
        String msg = "修改失败!";
        int index = 3;
        if(result >0){
            index = 0;
            msg = "修改成功!";
        }
        responceData = new ResponceData(ResponceDataState.values()[index].getCode(),msg,result);
        return responceData;
    }

    /**
     * 轮播图新增之 商品编号列表查询
     * @param good
     * @return
     */
    public ResponceData querylistGoods2(Good good){
        //查询参数是否为空
        //如果参数不完整
        if(good.getPageNum() == 0||good.getPageSize() == 0){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"页号或者页数量不能为空!",null);
            return responceData;
        }
        //查询数据列表
        PageHelper.startPage(good.getPageNum(),good.getPageSize());
        List<Good>goods = rotaChartDao.querylistGoods2(good);
        PageInfo<Good>pageInfo = new PageInfo<>(goods);
        //返回判断
        String msg = "查询为空!";
        int index = 3;
        if(goods.size() >0){
            index = 0;
            msg = "查询成功!";
        }
        responceData = new ResponceData(ResponceDataState.values()[index].getCode(),msg,pageInfo);
        return responceData;
    }
}
