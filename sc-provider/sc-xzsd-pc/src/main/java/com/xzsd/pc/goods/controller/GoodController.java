package com.xzsd.pc.goods.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.goods.entity.Good;
import com.xzsd.pc.goods.service.GoodService;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;

import javax.annotation.Resource;

/**
 * 商品控制类
 * zhc
 * 2020年3月25日16:07:15
 */

@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    private GoodService goodService;
    private ResponceData responceData;
//    private static final Logger logger = LoggerFactory.getLogger(GoodController.class);

    /**
     *  增加商品
     * @param good
     * @return responceData
     * @author zhc
     * @Date 2020年3月26日10:36:36
     */
    @ResponseBody
    @PostMapping("addGood")
    public ResponceData addGood(Good good){

            responceData = goodService.addGood(good);
            return responceData;
//        }catch(Exception e){
//            throw  e;
//        }
    }
    /**
     *  查询商品详情
     * @param good
     * @return responceData
     * @author zhc
     * @Date 2020年3月26日11:03:55
     */
    @PostMapping("queryGoodDetail")
    public ResponceData queryGoodDetail(Good good){
        responceData = goodService.queryGoodDetail(good);

        return responceData;

    }
    @PostMapping("deleteGood")
    public ResponceData deleteGoods(String goodCode){

        try{
            String updateUser = "123456";
            responceData = goodService.deleteGoods(goodCode,updateUser);
            return responceData;
        }
        catch(Exception e){
            throw e;
        }
    }

    /**
     * 修改商品
     * @param good
     * author:zhc
     * 2020年3月26日14:42:01
     * @return
     */
    @PostMapping("updateGood")
    public ResponceData updateGood(Good good){
        try{
            responceData = goodService.updateGoo(good);
            return responceData;
        }catch (Exception e){
            throw e;
        }

    }

    /**
     * 商品列表查询
     * @param good
     * @return
     */
    @PostMapping("queryGoodList")
    public ResponceData queryGoodList(Good good){
        try{
            responceData = goodService.queryGoodList(good);
            return responceData;
        }catch (Exception e){
            throw e;

        }



    }

    /**
     * 商品修改状态上架下架
     * @param good
     * 2020年3月26日22:35:50
     * @return
     */
    @PostMapping("upperOrLowerShelf")
    public ResponceData upperOrLowerShelf(Good good){

        try{
            responceData = goodService.updateGoodState(good,RandomCode.radmonkey());
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }

}
