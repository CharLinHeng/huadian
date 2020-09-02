package com.xzsd.app.store.dao;

import com.xzsd.app.driver.entity.AreaName;
import com.xzsd.app.store.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 订单详情查询
     * @param orderCode
     * @return
     */
    OrderDetail queryshopOwnerOrderDetail(@Param("orderCode")String orderCode);

    /**
     * 根据省市区编号 查询 名称
     */
    AreaName queryPCD(OrderDetail orderDetail);

    /**
     * 判断此用户是否存在店铺
     * @param username
     * @return
     */
    int getUserHasStore(@Param("username")String username);

    /**
     * 新增门店
     * @param store
     * @return
     */
    int addStore(Store store);

    /**
     * 商店审核
     * @param store
     * @return
     */
    int updateStoreJudgeState(Store store);
}
