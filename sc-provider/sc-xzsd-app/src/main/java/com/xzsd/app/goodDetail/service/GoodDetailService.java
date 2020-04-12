package com.xzsd.app.goodDetail.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.goodDetail.dao.GoodDetailDao;
import com.xzsd.app.goodDetail.entity.*;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Deprecated 商品详情Dao
 * @author zhc
 * @Time 2020年4月10日15:22:38
 */
@Service
public class GoodDetailService {
    /**
     * 商品详情查询
     * @param httpServletRequest
     * @return
     */
    @Resource
    private GoodDetailDao goodDetailDao;
    public ResponceData queryGoodDetail(HttpServletRequest httpServletRequest){
        //判断，如果参数编号为空，那么提示并返回结果
        if (null == httpServletRequest.getParameter("goodCode") || httpServletRequest.getParameter("goodCode") == "") {
            return new ResponceData(ResponceDataState.values()[3].getCode(),"商品编号参数不能为空!",null);
        }
        //查询
        Good goodData = goodDetailDao.queryGoodDetail(httpServletRequest.getParameter("goodCode"));
        if(null != goodData){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",goodData);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空",null);
    }

    /**
     * 商品评价列表查询
     * @param goodEvaParam
     * @return
     */
    public ResponceData queryGoodComEvaList(GoodEvaParam goodEvaParam){
        //判断参数是否缺失
        if(goodEvaParam.getPageNum() == 0 || goodEvaParam.getPageSize() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"页数量或者页号为空!",null);
        }
        if(null == goodEvaParam.getGoodCode() || goodEvaParam.getGoodCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"编号参数不能为空!",null);
        }
        //查询
        PageHelper.startPage(goodEvaParam.getPageNum(),goodEvaParam.getPageSize());
        List<GoodEva> goodEvaList = goodDetailDao.queryGoodComEvaList(goodEvaParam);
        PageInfo<GoodEva>goodEvaPageInfo = new PageInfo<>(goodEvaList);
        if(goodEvaList.size() > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",goodEvaPageInfo);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空",null);
    }

    /**
     *  客户绑定店铺查询
     * @param userParam
     * @return
     */
    public ResponceData queryUserBindStore(UserParam userParam){
        //参数判断
        if(null == userParam.getUserCode() || userParam.getUserCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"用户编号为空",null);
        }
        //查询
        UserBindStore userBindStore = goodDetailDao.queryUserBindStore(userParam);
        if(null == userBindStore){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"该用户没有绑定店铺!",null);
        }
        //查找省市区编号对应的名字,然后建立输出类，赋值，输出
        UserBindStore userBindStoreAddress = goodDetailDao.queryPCD(userBindStore);
        if(null != userBindStoreAddress){
            //拼接组合信息实体类，输出给前台
            UserBindData userBindData = new UserBindData();
            userBindData.setStoreName(userBindStore.getStoreName());
            userBindData.setStoreAddress(userBindStoreAddress.getProvinceCode()+userBindStoreAddress.getCityCode()+userBindStoreAddress.getDistinctCode()+
                    userBindStore.getStoreAddress());
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",userBindData);
        }

        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空",null);
    }
}
