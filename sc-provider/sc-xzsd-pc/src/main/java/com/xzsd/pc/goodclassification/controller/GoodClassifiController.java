package com.xzsd.pc.goodclassification.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.goodclassification.entity.GoodClassification;
import com.xzsd.pc.goodclassification.service.GoodClassifiService;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;

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



    ResponceData responceData;
    @Resource
    GoodClassifiService goodClassifiService;
    @ResponseBody

    /**
     * 商品一级分类新增
     */
    @PostMapping("addFirstClass")
    public ResponceData addFirstClass(GoodClassification goodClassification){
        try{
            responceData = goodClassifiService.addFirstClass(goodClassification);
            return responceData;
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
    public ResponceData addSecondClass(GoodClassification goodClassification){
        try{
            responceData = goodClassifiService.addSecondClass(goodClassification);
            return responceData;
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
    public ResponceData updateGoodClass(GoodClassification goodClassification) {
        try {
            responceData = goodClassifiService.updateGoodClass(goodClassification);
            return responceData;
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
    public ResponceData deleteGoodClass(HttpServletRequest httpServletRequest){
        try {
            String codeList = httpServletRequest.getParameter("classCode");
            String codeRank = httpServletRequest.getParameter("classRank");
            String updateUser = RandomCode.radmonkey();
            responceData = goodClassifiService.deleteGoodClass(codeList,codeRank,updateUser);
            return responceData;
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
    public ResponceData queryGoodClass(HttpServletRequest httpServletRequest){
        try {
            String code = httpServletRequest.getParameter("classCode");
            responceData = goodClassifiService.queryGoodClass(code);
            return responceData;
        } catch (Exception e) {
            throw e;

        }
    }

    /**
     * 商品分类列表查询
     * @return
     */
    @PostMapping("queryGoodClassList")
    public ResponceData queryGoodClassList(){
        try {
            responceData = goodClassifiService.queryGoodClassList();
            return responceData;
        } catch (Exception e) {
            throw e;

        }
    }
}
