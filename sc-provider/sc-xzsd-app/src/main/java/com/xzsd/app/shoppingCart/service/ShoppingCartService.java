package com.xzsd.app.shoppingCart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.shoppingCart.dao.ShoppingCartDao;
import com.xzsd.app.shoppingCart.entity.AddShoppingCart;
import com.xzsd.app.shoppingCart.entity.CartGoodList;
import com.xzsd.app.shoppingCart.entity.CartGoodUserParam;
import com.xzsd.app.util.RandomCode;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ShoppingCartService {
    @Resource
    private ShoppingCartDao shoppingCartDao;

    /**
     * 新增购物车
     *
     * @param addShoppingCart
     * @return
     */
    public ResponceData addShoppingCart(AddShoppingCart addShoppingCart) {
        //判断请求参数
        if (null == addShoppingCart.getGoodCode() || addShoppingCart.getGoodCode() == "") {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "商品编号参数缺失!", null);
        }
        if (null == addShoppingCart.getUserCode() || addShoppingCart.getUserCode() == "") {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "用户编号参数缺失!", null);
        }
        if (addShoppingCart.getGoodsNum() == 0) {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "商品数量参数缺失或者不能为0!", null);
        }
        //判断该商品是否还有足够的存货
        int saveLibGood = shoppingCartDao.checkGoodNumEnough(addShoppingCart.getGoodCode());
        if (saveLibGood < addShoppingCart.getGoodsNum()) {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "该商品库存不足!仅剩余" + saveLibGood + "件,无法购买" + addShoppingCart.getGoodsNum() + "件", null);
        }
        //查看这个用户的购物车是否已经有此类商品了，有的话，就更新商品数量，而不是新增
        String cartCode = shoppingCartDao.checkHasThisGoodInShoppingCart(addShoppingCart);
        if (null != cartCode && cartCode.length() > 0) {
            //说明已经存在，那么只需要更新商品数量就行了
            int result = shoppingCartDao.updateCartGoodNum(addShoppingCart);
            if (result > 0) {
                return new ResponceData(ResponceDataState.values()[0].getCode(), "更新购物车商品数量成功!", null);
            }
            return new ResponceData(ResponceDataState.values()[3].getCode(), "更新购物车商品数量失败!", null);
        }
        //随机生成编号
        addShoppingCart.setCartCode(RandomCode.radmonkey());
        //增加
        int result = shoppingCartDao.addShoppingCart(addShoppingCart);
        //结果
        if (result > 0) {
            return new ResponceData(ResponceDataState.values()[0].getCode(), "新增成功!", null);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(), "新增失败!", null);
    }

    /**
     * 购物车列表商品数量修改
     *
     * @param addShoppingCart
     * @return
     */
    public ResponceData updateShoppingCartGoods(AddShoppingCart addShoppingCart) {
        //先判断参数是否齐全
        if (null == addShoppingCart.getCartCode() || addShoppingCart.getCartCode() == "") {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "购物车编号参数缺失!", null);
        }
        if (null == addShoppingCart.getUserCode() || addShoppingCart.getUserCode() == "") {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "用户编号参数缺失!", null);
        }
        if (addShoppingCart.getGoodsNum() == 0) {
            //如果修改此购物车商品数量为0.那么直接删除购物车对应的购物车编号
            int result = shoppingCartDao.deleteCartGood(addShoppingCart);
            if (result > 0) {
                return new ResponceData(ResponceDataState.values()[0].getCode(), "删除购物车对应商品成功!", null);
            }
            return new ResponceData(ResponceDataState.values()[3].getCode(), "删除购物车对应商品失败!", null);
        }
        //判断该商品库存是否大于等于待修改的商品数量
        int saveLibGood = shoppingCartDao.checkGoodNumEnough(shoppingCartDao.findGoodCodeFromCart(addShoppingCart));
        if (saveLibGood < addShoppingCart.getGoodsNum()) {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "该商品库存不足!仅剩余" + saveLibGood + "件,无法购买" + addShoppingCart.getGoodsNum() + "件", null);
        }
        //修改
        int result = shoppingCartDao.updateCartGood(addShoppingCart);
        if (result > 0) {
            return new ResponceData(ResponceDataState.values()[0].getCode(), "修改数量成功!", null);
        }
        //结果
        return new ResponceData(ResponceDataState.values()[3].getCode(), "修改购物车商品数量失败!", null);
    }

    /**
     * 购物车商品删除
     * @param addShoppingCart
     * @return
     */
    public ResponceData deleteShoppingCartGoods(AddShoppingCart addShoppingCart){
        if (null == addShoppingCart.getCartCode() || addShoppingCart.getCartCode() == "") {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "购物车编号参数缺失!", null);
        }
        List<String> cartCodeList = Arrays.asList(addShoppingCart.getCartCode().split(","));
        int result = shoppingCartDao.deleteCartGoodNum(cartCodeList,addShoppingCart.getUserCode());
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(), "删除成功!数量:"+result, null);
        }
       return new ResponceData(ResponceDataState.values()[3].getCode(), "删除失败!", null);
    }

    /**
     * 购物车列表查询
     * @param cartGoodUserParam
     * @return
     */
    public ResponceData queryShoppingCartList(CartGoodUserParam cartGoodUserParam){
        //判断参数是否齐全
        if (null == cartGoodUserParam.getUserCode() || cartGoodUserParam.getUserCode() == "") {
            return new ResponceData(ResponceDataState.values()[3].getCode(), "用户编号参数缺失!", null);
        }
        if(cartGoodUserParam.getPageNum() == 0 || cartGoodUserParam.getPageSize() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(), "页号或者页数量参数为空或者不能为0", null);
        }
        //查询列表
        PageHelper.startPage(cartGoodUserParam.getPageNum(),cartGoodUserParam.getPageSize());
        List<CartGoodList>cartGoodLists = shoppingCartDao.queryShoppingCartList(cartGoodUserParam);
        PageInfo<CartGoodList>cartGoodListPageInfo = new PageInfo<>(cartGoodLists);
        //结果
        if(cartGoodLists.size() > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(), "查询成功!", cartGoodListPageInfo);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(), "获取为空!", null);
    }

}
