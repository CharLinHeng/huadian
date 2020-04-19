package com.xzsd.pc.goods.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.goods.entity.GoodClassifi;
import com.xzsd.pc.util.SecurityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.goods.entity.Good;
import com.xzsd.pc.goods.service.GoodService;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;

import javax.annotation.Resource;

/**
 * 商品控制类
 * zhc
 * 2020年3月25日16:07:15
 */

@RestController
@RequestMapping("/goods")
public class GoodController {
    @Resource
    private GoodService goodService;
    private AppResponse responceData;
//    private static final Logger logger = LoggerFactory.getLogger(GoodController.class);

    /**
     *  增加商品
     * @param good
     * @return responceData
     * @author zhc
     * @Date 2020年3月26日10:36:36
     */
    @ResponseBody
    @PostMapping("addGood")
    public AppResponse addGood(Good good){
        try{
            return goodService.addGood(good);
        }catch(Exception e){
            return AppResponse.bizError("执行过程有错误,抛出异常!"+e.getMessage());
        }
    }
    /**
     *  查询商品详情
     * @param good
     * @return responceData
     * @author zhc
     * @Date 2020年3月26日11:03:55
     */
    @PostMapping("queryDetail")
    public AppResponse queryGoodDetail(Good good){

        try{
            return goodService.queryGoodDetail(good);
        }catch (Exception e){
            return AppResponse.bizError("执行过程有错误,抛出异常!"+e.getMessage());
        }
    }
    @PostMapping("deleteGood")
    public AppResponse deleteGoods(String goodCode){

        try{
            String updateUser = SecurityUtils.getCurrentUserUsername();
            return goodService.deleteGoods(goodCode,updateUser);
        }
        catch(Exception e){
            return AppResponse.bizError("执行过程有错误,抛出异常!"+e.getMessage());
        }
    }

    /**
     * 修改商品
     * @param good
     * author:zhc
     * 2020年3月26日14:42:01
     * @return
     */
    @PostMapping("updateGood")
    public AppResponse updateGood(Good good){
        try{
            responceData = goodService.updateGoo(good);
            return responceData;
        }catch (Exception e){
            return AppResponse.bizError("执行过程有错误,抛出异常!"+e.getMessage());
        }

    }

    /**
     * 商品列表查询
     * @param good
     * @return
     */
    @PostMapping("listGoods")
    public AppResponse queryGoodList(Good good){
        try{
            responceData = goodService.queryGoodList(good);
            return responceData;
        }catch (Exception e){
            return AppResponse.bizError("执行过程有错误,抛出异常!"+e.getMessage());
        }

    }

    /**
     * 商品修改状态上架下架
     * @param good
     * 2020年3月26日22:35:50
     * @return
     */
    @PostMapping("upperOrLowerShelf")
    public AppResponse upperOrLowerShelf(Good good){

        try{
            responceData = goodService.updateGoodState(good,SecurityUtils.getCurrentUserUsername());
            return responceData;
        }catch (Exception e){
            return AppResponse.bizError("执行过程有错误,抛出异常!"+e.getMessage());
        }
    }

    /**
     * 商品一级分类查询
     * @return
     */
    @PostMapping("queryFirstClass")
    public AppResponse queryFirstClass(){
        try{
            responceData = goodService.queryFirstClass();
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }
    /**
     * 商品二级分类查询
     * @param goodClassifi
     * @return
     */
    @PostMapping("querySecondClass")
    public AppResponse querySecondClass(GoodClassifi goodClassifi){
        try{
            responceData = goodService.querySecondClass(goodClassifi);
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }

}
