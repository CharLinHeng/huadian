package com.xzsd.pc.order.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xzsd.pc.order.entity.Order;
import com.xzsd.pc.order.entity.OrderDetail;
import com.xzsd.pc.order.entity.OrderQuery;

import java.util.List;

/**
 * 订单Dao
 *
 */
@Mapper
public interface OrderDao {
    /**
     * 订单列表查询
     * @param orderQuery
     * @return
     */
    List<Order>queryOrderList(OrderQuery orderQuery);
    /**
     * 订单状态修改
     * @return
     */
    int updateOrderState(@Param("list") List<String> codes, @Param("orderState") int state,
                         @Param("updateUser") String updateUser, @Param("version") int version);
    /**
     * 订单详情
     * @param code
     * @return
     */
    List<OrderDetail>queryOrderDetail(@Param("orderCode") String code);
}
