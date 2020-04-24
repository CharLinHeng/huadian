package com.xzsd.app.goodDetail.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goodDetail.dao.GoodDetailDao;
import com.xzsd.app.goodDetail.entity.*;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import com.xzsd.app.util.SecurityUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Deprecated 商品详情service
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
    public AppResponse queryGoodDetail(HttpServletRequest httpServletRequest){
        //判断，如果参数编号为空，那么提示并返回结果
        if (null == httpServletRequest.getParameter("goodCode") || httpServletRequest.getParameter("goodCode") == "") {
            return AppResponse.paramError("商品编号参数不能为空!");
        }
        //查询
        Good goodData = goodDetailDao.queryGoodDetail(httpServletRequest.getParameter("goodCode"));
        //浏览量++
        GoodThrough goodThrough = new GoodThrough();
        goodThrough.setGoodCode(httpServletRequest.getParameter("goodCode"));
        goodThrough.setUpdateUser(SecurityUtils.getCurrentUserUsername());
        goodDetailDao.addGoodThrough(goodThrough);
        //判断结果
        if(null != goodData){
            return AppResponse.success("查询成功!",goodData);
        }
        return AppResponse.success("查询为空");
    }

    /**
     * 商品评价列表查询
     * @param goodEvaParam
     * @return
     */
    public AppResponse queryGoodComEvaList(GoodEvaParam goodEvaParam){
        //查询
        PageHelper.startPage(goodEvaParam.getPageNum(),goodEvaParam.getPageSize());
        List<GoodEva> goodEvaList = goodDetailDao.queryGoodComEvaList(goodEvaParam);
        PageInfo<GoodEva>goodEvaPageInfo = new PageInfo<>(goodEvaList);
        //判断结果
        if(goodEvaList.size() > 0){
            return AppResponse.success("查询成功!",goodEvaPageInfo);
        }
        return AppResponse.success("查询为空");
    }

    /**
     *  客户绑定店铺查询
     * @param userParam
     * @return
     */
    public AppResponse queryUserBindStore(UserParam userParam){
        //参数
        if(null == userParam.getUserCode() || userParam.getUserCode() == ""){
            return AppResponse.paramError("用户编号为空");
        }
        //查询
        UserBindStore userBindStore = goodDetailDao.queryUserBindStore(userParam);
        if(null == userBindStore){
            return AppResponse.paramError("该用户没有绑定店铺!");
        }
        //查找省市区编号对应的名字,然后建立输出类，赋值，输出
        UserBindStore userBindStoreAddress = goodDetailDao.queryPCD(userBindStore);
        //判断结果
        if(null != userBindStoreAddress){
            //赋值 输出信息实体类，输出给前台
            UserBindData userBindData = new UserBindData();
            userBindData.setStoreName(userBindStore.getStoreName());
            userBindData.setStoreAddress(userBindStoreAddress.getProvinceCode()+userBindStoreAddress.getCityCode()
                    +userBindStoreAddress.getDistinctCode()+ userBindStore.getStoreAddress());
            return AppResponse.success("查询成功!",userBindData);
        }
        return AppResponse.success("查询为空");
    }
}
