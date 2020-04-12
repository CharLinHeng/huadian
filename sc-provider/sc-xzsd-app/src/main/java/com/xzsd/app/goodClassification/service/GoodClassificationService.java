package com.xzsd.app.goodClassification.service;

import com.xzsd.app.goodClassification.dao.GoodClassiDao;
import com.xzsd.app.goodClassification.entity.GoodClassiSecond;
import com.xzsd.app.goodClassification.entity.GoodClassification;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * app端-商品分类列表页面Service
 */
@Service
public class GoodClassificationService {
    @Resource
    private GoodClassiDao goodClassiDao;

    /**
     * 商品一级分类查询
     *
     * @return
     */
    public ResponceData queryOneClass() {
        //查询
        List<GoodClassification> goodClassificationList = goodClassiDao.queryOneClass();
        if (goodClassificationList.size() > 0) {
            return new ResponceData(ResponceDataState.values()[0].getCode(), "查询成功!", goodClassificationList);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(), "查询为空", null);
    }

    /**
     * 商品二级分类及其对应的商品集合
     * @param goodClassification
     * @return
     */
    public ResponceData queryTwoClass(GoodClassification goodClassification) {
        //先判断一级分类参数是否存在
        if(null == goodClassification.getClassCode() || goodClassification.getClassCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(), "缺失一级分类编号参数!", null);
        }
        //查询
        List<GoodClassiSecond>goodClassiSeconds = goodClassiDao.queryTwoClass(goodClassification.getClassCode());
        //判断结果
        if(goodClassiSeconds.size() > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(), "查询成功!", goodClassiSeconds);
        }

        return new ResponceData(ResponceDataState.values()[3].getCode(), "查询为空", null);
    }
}