package com.xzsd.app.goodDetail.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goodDetail.entity.GoodEvaParam;
import com.xzsd.app.goodDetail.entity.UserParam;
import com.xzsd.app.goodDetail.service.GoodDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Deprecated 商品详情Controller
 * @author zhc
 * @Time 2020年4月10日15:22:38
 */
@RestController
@RequestMapping("/customer")
public class GoodDetailController {
    @Resource
    private GoodDetailService goodDetailService;
    @ResponseBody

    /**
     * 商品详情查询
     */
    @PostMapping("queryGoodDetail")
    public AppResponse queryGoodDetail(HttpServletRequest httpServletRequest){
        try{
            return goodDetailService.queryGoodDetail(httpServletRequest);
        }catch (Exception e){
            throw  e;
        }
    }

    /**
     * 商品评价列表查询
     * @param goodEvaParam
     * @return
     */
    @PostMapping("queryGoodComEvaList")
    public AppResponse queryGoodComEvaList(GoodEvaParam goodEvaParam){
        try{
            return goodDetailService.queryGoodComEvaList(goodEvaParam);
        }catch (Exception e){
            throw  e;
        }
    }

    /**
     *  客户绑定店铺查询
     * @param userParam
     * @return
     */
    @PostMapping("queryUserBindStore")
    public AppResponse queryUserBindStore(UserParam userParam){
        try{
            return goodDetailService.queryUserBindStore(userParam);
        }catch (Exception e){
            throw  e;
        }
    }

}
