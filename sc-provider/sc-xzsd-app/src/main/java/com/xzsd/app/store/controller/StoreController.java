package com.xzsd.app.store.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.store.entity.OrderDetail;
import com.xzsd.app.store.entity.OrderUpdate;
import com.xzsd.app.store.entity.Store;
import com.xzsd.app.store.entity.StoreOrderListParam;
import com.xzsd.app.store.service.StoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Resource
    private StoreService storeService;

    /**
     * 店长订单状态修改
     * @param orderUpdate
     * @return
     */
    @ResponseBody
    @PostMapping("updateShopOwnerOrderState")
    public AppResponse updateShopOwnerOrderState(OrderUpdate orderUpdate){
        try{
            return storeService.updateShopOwnerOrderState(orderUpdate);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 店长-订单列表查询
     * @param storeOrderListParam
     * @return
     */
    @PostMapping("queryshopOwnerOrderList")
    public AppResponse queryshopOwnerOrderList(StoreOrderListParam storeOrderListParam){
        try{
            return storeService.queryshopOwnerOrderList(storeOrderListParam);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderDetail
     * @return
     */
    @PostMapping("queryshopOwnerOrderDetail")
    public AppResponse queryshopOwnerOrderDetail(OrderDetail orderDetail){
        try{
            return storeService.queryshopOwnerOrderDetail(orderDetail);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 新增门店
     * @param orderDetail
     * @return
     */
    @PostMapping("addStore")
    public AppResponse addStore(Store orderDetail){
        try{
            return storeService.addStore(orderDetail);
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping("updateStoreJudgeState")
    public AppResponse updateStoreJudgeState(Store orderDetail){
        try{
            return storeService.updateStoreJudgeState(orderDetail);
        }catch (Exception e){
            throw e;
        }
    }



}
