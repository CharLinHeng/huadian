package com.xzsd.app.shoppingCart.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.shoppingCart.entity.AddShoppingCart;
import com.xzsd.app.shoppingCart.entity.CartGoodUserParam;
import com.xzsd.app.shoppingCart.service.ShoppingCartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhc
 * @Deprecated 购物车Controller
 * @time 2020年4月11日13:45:58
 */
@RestController
@RequestMapping("customer")
public class ShoppingCartController {
    @Resource
    private ShoppingCartService shoppingCartService;

    @ResponseBody
    /**
     * 增加购物车商品
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(AddShoppingCart addShoppingCart) {
        try {
            return shoppingCartService.addShoppingCart(addShoppingCart);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 修改购物车商品
     *
     * @param addShoppingCart
     * @return
     */
    @PostMapping("updateShoppingCartGoods")
    public AppResponse updateShoppingCartGoods(AddShoppingCart addShoppingCart) {
        try {
            return shoppingCartService.updateShoppingCartGoods(addShoppingCart);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 删除购物车数量
     * @param addShoppingCart
     * @return
     */
    @PostMapping("deleteShoppingCartGoods")
    public AppResponse deleteShoppingCartGoods(AddShoppingCart addShoppingCart) {
        try {
            return shoppingCartService.deleteShoppingCartGoods(addShoppingCart);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 购物车列表查询
     * @param cartGoodUserParam
     * @return
     */
    @PostMapping("queryShoppingCartList")
    public AppResponse queryShoppingCartList(CartGoodUserParam cartGoodUserParam) {
        try {
            return shoppingCartService.queryShoppingCartList(cartGoodUserParam);
        } catch (Exception e) {
            throw e;
        }
    }

}
