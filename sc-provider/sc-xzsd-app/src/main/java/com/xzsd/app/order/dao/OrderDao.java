package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.AddOrder;
import com.xzsd.app.order.entity.GoodBigThanLibs;
import com.xzsd.app.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * app端-用户订单Dao
 */
@Mapper
public interface OrderDao {
    /**
     * 增加订单
     * @param order
     * @return
     */
    int addUserOrder(Order order);

    /**
     * 判断商品库存是否充足
     * @param cartCodeList
     * @return
     */
    List<GoodBigThanLibs>judgementStock(@Param("cartCodeList") List<String> cartCodeList);
}
