package com.xzsd.app.store.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.store.dao.StoreDao;
import com.xzsd.app.store.entity.OrderUpdate;
import com.xzsd.app.store.entity.StoreOrderList;
import com.xzsd.app.store.entity.StoreOrderListParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店长-订单服务类
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 订单状态更新
     * @param orderUpdate
     * @return
     */
    public AppResponse updateShopOwnerOrderState(OrderUpdate orderUpdate){
        if(null == orderUpdate.getOrderCode()){
            return AppResponse.notFound("订单编号参数未找到");
        }
        int result = storeDao.updateShopOwnerOrderState(orderUpdate);
        if(result > 0){
            return AppResponse.success("更新订单状态成功!",result);
        }
        return AppResponse.serverError("修改订单状态失败");
    }

    /**
     * 店长-订单列表查询
     * @param storeOrderListParam
     * @return
     */
    public AppResponse queryshopOwnerOrderList(StoreOrderListParam storeOrderListParam){
        if(null == storeOrderListParam.getUserCode()){
            return AppResponse.notFound("店长编号参数未找到");
        }
        List<StoreOrderList> orderList = storeDao.queryshopOwnerOrderList(storeOrderListParam);
        if(orderList.size() > 0){
            return AppResponse.success("查询成功!",orderList);
        }
        return AppResponse.serverError("查询为空");
    }
}
