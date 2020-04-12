package com.xzsd.app.goodClassification.controller;

import com.xzsd.app.goodClassification.entity.GoodClassification;
import com.xzsd.app.goodClassification.service.GoodClassificationService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class GoodClassificationController {
    @Resource
    private GoodClassificationService goodClassificationService;
    @ResponseBody
    /**
     * 商品一级分类查询
     */
    @PostMapping("queryOneClass")
    public ResponceData queryOneClass(){
        try{
            return goodClassificationService.queryOneClass();
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 商品二级分类和对应商品查询
     * @return
     */
    @PostMapping("queryTwoClass")
    public ResponceData queryTwoClass(GoodClassification goodClassification){
        try{
            return goodClassificationService.queryTwoClass(goodClassification);
        }catch (Exception e){
            throw e;
        }
    }
}
