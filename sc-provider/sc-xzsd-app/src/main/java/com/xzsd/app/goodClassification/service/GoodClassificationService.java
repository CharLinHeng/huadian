package com.xzsd.app.goodClassification.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goodClassification.dao.GoodClassiDao;
import com.xzsd.app.goodClassification.entity.GoodClassiSecond;
import com.xzsd.app.goodClassification.entity.GoodClassification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Deprecated  app端-商品分类列表页面Service
 * @Time 2020年4月13日16:33:13
 * @author zhc
 */
@Service
public class GoodClassificationService {
    @Resource
    private GoodClassiDao goodClassiDao;
    /**
     * 商品一级分类查询
     * @return
     */
    public AppResponse queryOneClass() {
        //查询
        List<GoodClassification> goodClassificationList = goodClassiDao.queryOneClass();
        if (goodClassificationList.size() > 0) {
            return AppResponse.success( "查询成功!", goodClassificationList);
        }
        return AppResponse.success( "查询为空");
    }
    /**
     * 商品二级分类及其对应的商品集合
     * @param goodClassification
     * @return
     */
    public AppResponse queryTwoClass(GoodClassification goodClassification) {
        //先判断一级分类参数是否存在
        if(null == goodClassification.getClassCode() || goodClassification.getClassCode() == ""){
            return AppResponse.paramError( "缺失一级分类编号参数!");
        }
        //查询
        List<GoodClassiSecond>goodClassiSeconds = goodClassiDao.queryTwoClass(goodClassification.getClassCode());
        //判断结果
        if(goodClassiSeconds.size() > 0){
            return AppResponse.success("查询成功!", goodClassiSeconds);
        }
        return AppResponse.success( "查询为空");
    }
}