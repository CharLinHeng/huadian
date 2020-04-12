package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.AddOrder;
import com.xzsd.app.order.entity.GoodBigThanLibs;
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
     * @param addOrder
     * @return
     */
    int addUserOrder(AddOrder addOrder);

    /**
     * 判断商品库存是否充足
     * @param cartCodeList
     * @return
     */
    List<GoodBigThanLibs>judgementStock(@Param("cartCodeList") List<String> cartCodeList);
}
