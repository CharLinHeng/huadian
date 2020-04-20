package com.xzsd.pc.goodclassification.controller;


import com.neusoft.core.restful.AppResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.goodclassification.entity.GoodClassification;
import com.xzsd.pc.goodclassification.service.GoodClassifiService;
import com.xzsd.pc.util.RandomCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("goodTypeManger")
/**
 * 商品分类管理 Controller
 * zhc
 * 2020年4月4日15:10:31
 */
public class GoodClassifiController {
    @Resource
    GoodClassifiService goodClassifiService;
    @ResponseBody

    /**
     * 商品一级分类新增
     */
    @PostMapping("addFirstClass")
    public AppResponse addFirstClass(GoodClassification goodClassification){
        try{
            return goodClassifiService.addFirstClass(goodClassification);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 新增二级分类
     * @param goodClassification
     * @return
     */
    @PostMapping("addSecondClass")
    public AppResponse addSecondClass(GoodClassification goodClassification){
        try{
            return  goodClassifiService.addSecondClass(goodClassification);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 更新分类
     * @param goodClassification
     * @return
     */
    @PostMapping("updateGoodClass")
    public AppResponse updateGoodClass(GoodClassification goodClassification) {
        try {
            return  goodClassifiService.updateGoodClass(goodClassification);
        } catch (Exception e) {
            throw e;

        }
    }

    /**
     * 商品分类删除
     * @param httpServletRequest
     * @return
     */
    @PostMapping("deleteGoodClass")
    public AppResponse deleteGoodClass(HttpServletRequest httpServletRequest){
        try {
            String codeList = httpServletRequest.getParameter("classCode");
            String codeRank = httpServletRequest.getParameter("classRank");
            String updateUser = RandomCode.radmonkey();
            return  goodClassifiService.deleteGoodClass(codeList,codeRank,updateUser);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 商品分类详情查询
     * @param httpServletRequest
     * @return
     */
    @PostMapping("queryGoodClass")
    public AppResponse queryGoodClass(HttpServletRequest httpServletRequest){
        try {
            String code = httpServletRequest.getParameter("classCode");
            return  goodClassifiService.queryGoodClass(code);
        } catch (Exception e) {
            throw e;

        }
    }

    /**
     * 商品分类列表查询
     * @return
     */
    @PostMapping("queryGoodClassList")
    public AppResponse queryGoodClassList(){
        try {
            return  goodClassifiService.queryGoodClassList();
        } catch (Exception e) {
            throw e;
        }
    }
}
