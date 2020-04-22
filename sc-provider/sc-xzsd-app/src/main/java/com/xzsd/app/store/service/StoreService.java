package com.xzsd.app.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.entity.AreaName;
import com.xzsd.app.store.dao.StoreDao;
import com.xzsd.app.store.entity.OrderDetail;
import com.xzsd.app.store.entity.OrderUpdate;
import com.xzsd.app.store.entity.StoreOrderList;
import com.xzsd.app.store.entity.StoreOrderListParam;
import org.apache.catalina.security.SecurityUtil;
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
            return AppResponse.paramError("订单编号参数未找到");
        }
        int result = storeDao.updateShopOwnerOrderState(orderUpdate);
        if(result > 0){
            return AppResponse.success("更新订单状态成功!",result);
        }
        return AppResponse.bizError("修改订单状态失败");
    }

    /**
     * 店长-订单列表查询
     * @param storeOrderListParam
     * @return
     */
    public AppResponse queryshopOwnerOrderList(StoreOrderListParam storeOrderListParam){
        //获取店长编号
        storeOrderListParam.setUserCode(SecurityUtils.getCurrentUserId());
        //获取信息
        List<StoreOrderList> orderList = storeDao.queryshopOwnerOrderList(storeOrderListParam);
        if(orderList.size() > 0){
            return AppResponse.success("查询成功!",orderList);
        }
        return AppResponse.bizError("查询为空");
    }

    /**
     * 2 店长订单详情查询
     * @param orderDetail
     * @return
     */
    public AppResponse queryshopOwnerOrderDetail(OrderDetail orderDetail){
        if(null == orderDetail.getOrderCode() || orderDetail.getOrderCode() == ""){
            return AppResponse.paramError("订单编号参数缺失!");
        }
        //查询
        OrderDetail orderDetailOut = storeDao.queryshopOwnerOrderDetail(orderDetail.getOrderCode());
        AreaName areaName = storeDao.queryPCD(orderDetailOut);
        orderDetailOut.setDeliveryAddress(areaName.getProvinceName()+areaName.getCityName()+areaName.getDistinctName()+orderDetailOut.getDeliveryAddress());
        //清空省市区编号
        orderDetailOut.setProvinceCode(null);
        orderDetailOut.setCityCode(null);
        orderDetailOut.setDistinctCode(null);
        //判断结果
        if(null != orderDetailOut){
            return AppResponse.success("查询成功!",orderDetailOut);
        }
        return AppResponse.serverError("查询为空");
    }
}
