package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.AddOrder;
import com.xzsd.app.order.entity.GoodBigThanLibs;
import com.xzsd.app.order.entity.GoodsExpired;
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
    int addUserOrder(AddOrder order);

    /**
     * 判断商品库存是否充足
     * @param cartCodeList
     * @return
     */
    List<GoodBigThanLibs>judgementStock(@Param("cartCodeList") List<String> cartCodeList);

    /**
     * 清空购物车
     * @param addOrder
     * @return
     */
    int clearEmpty(AddOrder addOrder);

    /**
     * 查询某些商品是否已经下架,返回已下架的商品
     * @param goodsCode
     * @return
     */
    List<GoodsExpired>goodsExpired(@Param("list")List<String>goodsCode);
    /**
     * 修改商品数量为库存最大，因为购买的商品数量库存比购物车的对应的商品数量要少,如果库存为0，则删除购物车
     * @param cartCodes
     * @return
     */
    int updateGoodNum(@Param("list")List<String>cartCodes);

    /**
     * 新建订单详情的商品列表
     * @param orderList
     * @return
     */
    int addOrder(@Param("list")List<Order>orderList);

    /**
     * 准备创建订单，进行查询待购买的商品的信息
     * @param codeLists
     * @return
     */
    List<Order> queryOrderList(@Param("list")List<String>codeLists);
}
