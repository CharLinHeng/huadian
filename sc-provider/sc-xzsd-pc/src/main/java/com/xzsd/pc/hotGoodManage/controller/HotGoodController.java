package com.xzsd.pc.hotGoodManage.controller;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.hotGoodManage.entity.*;
import com.xzsd.pc.hotGoodManage.service.HotGoodService;
import com.xzsd.pc.util.ResponceData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hotGoodManage")
public class HotGoodController {
    private ResponceData responceData;

    @Resource
    private HotGoodService hotGoodService;


    @ResponseBody

    /**
     * 热门商品位新增
     */
    @PostMapping("addHotGood")
    public ResponceData addHotGood(HotGood hotGood){
        try{

            responceData = hotGoodService.addHotGood(hotGood);
            return responceData;
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
    public ResponceData queryGoodsList(HttpServletRequest httpServletRequest, HotGoodQuery hotGoodQuery){
        try{
            responceData = hotGoodService.queryGoodsList(httpServletRequest,hotGoodQuery);
            return responceData;
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
    public ResponceData updateHotGood(HotGood hotGood){
        try{
            responceData = hotGoodService.updateHotGood(hotGood);
            return responceData;
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
    public ResponceData deleteHotGood(HotGood hotGood){
        try{
            responceData = hotGoodService.deleteHotGood(hotGood);
            return responceData;
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
    public ResponceData showHotGoodsNum(ShowNum showNum){
        try{
            responceData = hotGoodService.showHotGoodsNum(showNum);
            return responceData;
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
    public ResponceData queryHotGoodsList(HotGoodList hotGoodlist, HttpServletRequest httpServletRequest){
        try{
            responceData = hotGoodService.queryHotGoodsList(hotGoodlist,httpServletRequest);
            return responceData;
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
    public ResponceData queryHotGoodDetail(HotGood hotGood){
        try{
            responceData = hotGoodService.queryHotGoodDetail(hotGood);
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }
}
