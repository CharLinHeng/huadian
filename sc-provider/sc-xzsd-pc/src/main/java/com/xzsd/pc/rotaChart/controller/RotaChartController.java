package com.xzsd.pc.rotaChart.controller;
import com.neusoft.core.restful.AppResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.goods.entity.Good;
import com.xzsd.pc.rotaChart.entity.RotaChart;
import com.xzsd.pc.rotaChart.service.RotService;
import com.xzsd.pc.util.RandomCode;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/rotaChart")
/**
 * 轮播图controller
 * zhc
 * 2020年3月27日15:35:40
 */
public class RotaChartController {
    @Resource
    private RotService rotService;
    @ResponseBody
    @PostMapping("/addRotaChart")
    /**
     * 增加轮播图
     * zhc
     * 2020年3月27日16:16:54
     *
     */
    public AppResponse addRotaChart(RotaChart rotaChart){
        try{
            rotaChart.setRotaChartCode(RandomCode.radmonkey());
            return rotService.addRotaChart(rotaChart);
        }
        catch (Exception e){
            throw e;
        }
    }
    /**
     * 删除轮播图
     * @param rotaChart
     * @return
     */
    @PostMapping("/deleteRotaChart")
    public AppResponse deleteRotaChart(RotaChart rotaChart){
        try{
            return rotService.deleteRotaChart(rotaChart);
        }
        catch(Exception e){
            throw e;
        }
    }

    /**
     * 查询轮播图列表
     * zhc
     * 2020年3月27日20:26:47
     * @param rotaChart
     * @return
     */
    @PostMapping("/queryRotaChartList")
    public AppResponse queryRotaChartList(RotaChart rotaChart){
        try{
           return rotService.queryRotaChartList(rotaChart);
        }
        catch(Exception e){
            throw e;
        }
    }

    /**
     * 轮播图启用禁用修改
     * @param httpServletRequest
     * @return
     */
    @PostMapping("updateRotaChartState")
    public AppResponse updateRotaChartState(HttpServletRequest httpServletRequest){
        try{
            return rotService.updateRotaChartState(httpServletRequest.getParameter("rotaChartStateCode"),
                    httpServletRequest.getParameter("rotaChartState"));
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 轮播图新增之 商品编号列表查询
     * @param good
     * @return
     */
    @PostMapping("listGoodsSecond")
    public AppResponse listGoodsSecond(Good good){
        try{
            return rotService.querylistGoodsSecond(good);
        }catch (Exception e){
            throw e;
        }
    }
}
