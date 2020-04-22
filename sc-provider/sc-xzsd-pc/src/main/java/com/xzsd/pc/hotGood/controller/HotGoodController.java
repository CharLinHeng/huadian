package com.xzsd.pc.hotGood.controller;


import com.neusoft.core.restful.AppResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.hotGood.entity.*;
import com.xzsd.pc.hotGood.service.HotGoodService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hotGoodManage")
public class HotGoodController {
    @Resource
    private HotGoodService hotGoodService;


    @ResponseBody

    /**
     * 热门商品位新增
     */
    @PostMapping("addHotGood")
    public AppResponse addHotGood(HotGood hotGood){
        try{
            
           return hotGoodService.addHotGood(hotGood);
            
        }catch (Exception e){
            throw e;
        }


    }

    /**
     * 热门商品位新增之商品列表查询
     * @param httpServletRequest
     * @param hotGoodQuery
     * @return
     */
    @PostMapping("queryGoodsList")
    public AppResponse queryGoodsList(HttpServletRequest httpServletRequest, HotGoodQuery hotGoodQuery){
        try{
           return hotGoodService.queryGoodsList(httpServletRequest,hotGoodQuery);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     *  热门商品位修改
     * @param hotGood
     * @return
     */
    @PostMapping("updateHotGood")
    public AppResponse updateHotGood(HotGood hotGood){
        try{
           return hotGoodService.updateHotGood(hotGood);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 4 热门商品位删除
     * @param hotGood
     * @return
     */
    @PostMapping("deleteHotGood")
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGood(HotGood hotGood){
        try{
           return hotGoodService.deleteHotGood(hotGood);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 数量
     * @param showNum
     * @return
     */
    @PostMapping("showHotGoodsNum")
    public AppResponse showHotGoodsNum(ShowNum showNum){
        try{
           return hotGoodService.showHotGoodsNum(showNum);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 热门商品位列表查询
     * @param hotGoodlist
     * @param httpServletRequest
     * @return
     */
    @PostMapping("queryHotGoodsList")
    public AppResponse queryHotGoodsList(HotGoodList hotGoodlist, HttpServletRequest httpServletRequest){
        try{
           return hotGoodService.queryHotGoodsList(hotGoodlist,httpServletRequest);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 热门商品位详情
     * @param hotGood
     * @return
     */
    @PostMapping("queryHotGoodDetail")
    public AppResponse queryHotGoodDetail(HotGood hotGood){
        try{
           return hotGoodService.queryHotGoodDetail(hotGood);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 查询商品展示数量
     * @return
     */
    @PostMapping("queryHotGoodNum")
    public AppResponse queryHotGoodNum(){
        try{
            return hotGoodService.queryHotGoodNum();
        }catch (Exception e){
            throw e;
        }
    }
}
