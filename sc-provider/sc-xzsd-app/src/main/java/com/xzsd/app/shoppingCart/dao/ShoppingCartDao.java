package com.xzsd.app.shoppingCart.dao;

import com.xzsd.app.shoppingCart.entity.AddShoppingCart;
import com.xzsd.app.shoppingCart.entity.CartGoodList;
import com.xzsd.app.shoppingCart.entity.CartGoodUserParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCartDao {
    /**
     * 增加商品购物车商品
     *
     * @param addShoppingCart
     * @return
     */
    int addShoppingCart(AddShoppingCart addShoppingCart);

    /**
     * 加入购物车时，查询该商品库存数量是否还充足
     *
     * @param goodCode
     * @return
     */
    int checkGoodNumEnough(@Param("goodCode") String goodCode);

    /**
     * 检测商品是否已经在购物车里面
     *
     * @param addShoppingCart
     * @return
     */
    String checkHasThisGoodInShoppingCart(AddShoppingCart addShoppingCart);

    /**
     * 从购物车表中查找该商品编号
     * @param addShoppingCart
     * @return
     */
    String findGoodCodeFromCart(AddShoppingCart addShoppingCart);
    /**
     * 新增购物车时更新商品数量
     *
     * @param addShoppingCart
     * @return
     */
    int updateCartGoodNum(AddShoppingCart addShoppingCart);

    /**
     * 删除购物车对应编号的商品
     *
     * @param addShoppingCart
     * @return
     */
    int deleteCartGood(AddShoppingCart addShoppingCart);

    /**
     * 修改购物车商品数量
     * @param addShoppingCart
     * @return
     */
    int updateCartGood(AddShoppingCart addShoppingCart);

    /**
     * 批量删除购物车商品
     * @param cartCodeList
     * @param userCode
     * @return
     */
    int deleteCartGoodNum(@Param("cartCodeList") List<String> cartCodeList,@Param("userCode")String userCode);

    /**
     * 购物车列表查询
     * @param cartGoodUserParam
     * @return
     */
    List<CartGoodList>queryShoppingCartList(CartGoodUserParam cartGoodUserParam);
}
