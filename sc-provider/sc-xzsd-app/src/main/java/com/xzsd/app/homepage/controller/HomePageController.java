package com.xzsd.app.homepage.controller;

import com.xzsd.app.homepage.service.HomePageService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 首页Controller类
 */
@RestController
@RequestMapping("/customer")
public class HomePageController {
    @Resource
    private HomePageService homePageService;
    @ResponseBody
    /**
     * 首页-轮播图
     */
    @PostMapping("queryRotateChartsList")
    public ResponceData queryRotateChartsList(){
        try{
            return homePageService.queryRotateChartsList();
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 热门商品列表查询
     * @return
     */
    @PostMapping("queryHotGoodsList")
    public ResponceData queryHotGoodsList(){
        try{
            return homePageService.queryHotGoodsList();
        }catch (Exception e){
            throw e;
        }
    }

}
