package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

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
     * @param cartCodeList
     * @return
     */
    int clearEmpty(@Param("list") List<String> cartCodeList);

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
     * 新增到订单详情  表
     * @param orderList
     * @return
     */
    int addOrderList(@Param("list") List<Order>orderList);
    /**
     * 准备创建订单，进行查询待购买的商品的信息
     * @param codeLists
     * @return
     */
    List<Order> queryOrderList(@Param("list")List<String>codeLists);

    /**
     * 新增顾客
     * @param customer
     * @return
     */
    int addCustomer(Customer customer);

    /**
     * 查询顾客信息
     * @param userCode
     * @return
     */
    Customer queryCustomerData(@Param("userCode")String userCode);

    /**
     * 订单编号
     * @param orderCode
     * @return
     */
    OrderDetail queryOrderDetail(@Param("orderCode")String orderCode);

    /**
     * 修改订单状态
     * @param updateOrder
     * @return
     */
    int updateOrder(UpdateOrder updateOrder);

    /**
     * 用户订单列表查询
     * @param orderListParam
     * @return
     */
    List<OrderList>queryUserOrderList(OrderListParam orderListParam);

    /**
     * 新增商品评价
     * @param orderEvaUnits
     * @param orderCode
     * @return
     */
    int addOrderGoodsEva(@Param("list")List<OrderEvaUnit>orderEvaUnits, @Param("orderCode")String orderCode);

    /**
     * 订单删除
     * @param orderCode
     * @param updateUser
     * @return
     */
    int deleteOrder(@Param("orderCode")String orderCode,@Param("createUser")String updateUser);

    /**
     * 更新操作
     * @param orderList
     * @return
     */
    int updateGoodRelative(@Param("list")List<Order>orderList);

    /**
     * 更新商品售空状态
     * @param orderList
     * @return
     */
    int updateGoodState(@Param("list")List<Order>orderList);
    /**
     * 更新商品星级
     * @param orderEva
     * @return
     */
    int updateGoodRank(@Param("list")List<OrderEvaUnit> orderEva);

    /**
     * 根据订单编号找到对饮商品编号和 数量
     * @param code
     * @return
     */
    List<GetOrderGoodCodeAndNum>queryOrderGoodCode(@Param("orderCode")String code);

    /**
     * 恢复商品的数量和售出量
     * @param getOrderGoodCodeAndNumList
     * @return
     */
    int updateGoodLibSaveAndSaleNum(@Param("list")List<GetOrderGoodCodeAndNum>getOrderGoodCodeAndNumList);

    /**
     * 更新商品状态为  在售
     * @param getOrderGoodCodeAndNumList
     * @return
     */
    int updateGoodSaleState(@Param("list")List<GetOrderGoodCodeAndNum>getOrderGoodCodeAndNumList);
    /**
     * 更新订单总价格
     * @param updateOrderPrice
     * @return
     */
    int updateOrderCount(UpdateOrderPrice updateOrderPrice);

    /**
     * 查看该商品是否已经下架或者卖完
     * @param buyNow
     * @return
     */
    Order queryIsNullOrExpired(BuyNow buyNow);
    /**
     * 快速购买新增订单
     * @param buyNow
     * @return
     */
    int addFastBuyOrder(BuyNow buyNow);
}
