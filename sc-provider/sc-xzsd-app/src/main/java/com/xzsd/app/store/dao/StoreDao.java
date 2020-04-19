package com.xzsd.app.store.dao;

import com.xzsd.app.store.entity.OrderUpdate;
import com.xzsd.app.store.entity.StoreOrderList;
import com.xzsd.app.store.entity.StoreOrderListParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreDao {
    /**
     * 更细订单状态
     * @param orderUpdate
     * @return
     */
    int updateShopOwnerOrderState(OrderUpdate orderUpdate);

    /**
     * 店长订单列表查询
     * @param storeOrderListParam
     * @return
     */
    List<StoreOrderList>queryshopOwnerOrderList(StoreOrderListParam storeOrderListParam);
}
