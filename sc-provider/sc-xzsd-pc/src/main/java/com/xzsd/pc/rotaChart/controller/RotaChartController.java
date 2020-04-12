package com.xzsd.pc.rotaChart.controller;


        import org.apache.ibatis.annotations.Param;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.bind.annotation.RestController;
        import com.xzsd.pc.goodsManage.entity.Good;
        import com.xzsd.pc.rotaChart.entity.RotaChart;
        import com.xzsd.pc.rotaChart.service.RotService;
        import com.xzsd.pc.util.RandomCode;
        import com.xzsd.pc.util.ResponceData;
        import com.xzsd.pc.util.ResponceListData;

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
    private ResponceData responceData;
    @ResponseBody
    @PostMapping("/addRotaChart")
    /**
     * 增加轮播图
     * zhc
     * 2020年3月27日16:16:54
     *
     */
    public ResponceData addRotaChart(RotaChart rotaChart){

        try{
            rotaChart.setRotaChartCode(RandomCode.radmonkey());
            responceData = rotService.addRotaChart(rotaChart);
            return responceData;
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
    public ResponceData deleteRotaChart(RotaChart rotaChart){
        try{
            responceData = rotService.deleteRotaChart(rotaChart);
            return responceData;
        }
        catch
        (Exception e){
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
    public ResponceListData queryRotaChartList(RotaChart rotaChart){
        try{
            ResponceListData responceListData;
            responceListData = rotService.queryRotaChartList(rotaChart);
            return responceListData;
        }
        catch
        (Exception e){
            throw e;
        }
    }

    /**
     * 轮播图启用禁用修改
     * @param httpServletRequest
     * @return
     */
    @PostMapping("updateRotaChartState")
    public ResponceData updateRotaChartState(HttpServletRequest httpServletRequest){

        try{
            responceData = rotService.updateRotaChartState(httpServletRequest.getParameter("rotaChartStateCode"),
                    httpServletRequest.getParameter("rotaChartState"));
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 轮播图新增之 商品编号列表查询
     * @param good
     * @return
     */
    @PostMapping("listGoods2")
    public ResponceData listGoods2(Good good){
        try{
            responceData = rotService.querylistGoods2(good);
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }


}
