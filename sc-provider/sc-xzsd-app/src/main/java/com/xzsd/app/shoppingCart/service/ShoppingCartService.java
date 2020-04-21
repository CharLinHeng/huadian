package com.xzsd.app.shoppingCart.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.shoppingCart.dao.ShoppingCartDao;
import com.xzsd.app.shoppingCart.entity.AddShoppingCart;
import com.xzsd.app.shoppingCart.entity.CartGoodList;
import com.xzsd.app.shoppingCart.entity.CartGoodUserParam;
import com.xzsd.app.util.RandomCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * @author zhc
 * @Deprecated 购物车Service
 * @time 2020年4月11日13:45:58
 */
@Service
public class ShoppingCartService {
    @Resource
    private ShoppingCartDao shoppingCartDao;

    /**
     * 新增购物车
     * @param addShoppingCart
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShoppingCart(AddShoppingCart addShoppingCart) {
        //判断请求参数
        if (null == addShoppingCart.getGoodCode() || addShoppingCart.getGoodCode() == "") {
            return AppResponse.paramError("商品编号参数缺失!");
        }
        if (null == addShoppingCart.getUserCode() || addShoppingCart.getUserCode() == "") {
            return AppResponse.paramError("用户编号参数缺失!");
        }
        //购买的商品的数量不能为0
        if (addShoppingCart.getGoodsNum() == 0) {
            return AppResponse.paramError("商品数量参数缺失或者不能为0!");
        }
        //判断该商品是否还有足够的库存
        int saveLibGood = shoppingCartDao.checkGoodNumEnough(addShoppingCart.getGoodCode());
        if (saveLibGood < addShoppingCart.getGoodsNum()) {
            return AppResponse.paramError("该商品库存不足!仅剩余" + saveLibGood + "件,无法购买" + addShoppingCart.getGoodsNum() + "件");
        }
        //查看这个用户的购物车 .判断其是否已经有此类商品了，有的话，就更新商品数量，而不是新增
        String cartCode = shoppingCartDao.checkHasThisGoodInShoppingCart(addShoppingCart);
        if (null != cartCode && cartCode.length() > 0) {
            //说明已经存在，那么只需要更新商品数量就行了
            int result = shoppingCartDao.updateCartGoodNum(addShoppingCart);
            if (result > 0) {
                return AppResponse.success( "更新购物车商品数量成功!");
            }
            return AppResponse.bizError("更新购物车商品数量失败!");
        }
        //随机生成编号
        addShoppingCart.setCartCode(RandomCode.radmonkey());
        //增加
        int result = shoppingCartDao.addShoppingCart(addShoppingCart);
        //结果
        if (result > 0) {
            return AppResponse.success( "新增成功!");
        }
        return AppResponse.paramError("新增失败!");
    }

    /**
     * 购物车列表商品数量修改
     * @param addShoppingCart
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShoppingCartGoods(AddShoppingCart addShoppingCart) {
        //先判断参数是否齐全
        if (null == addShoppingCart.getCartCode() || addShoppingCart.getCartCode() == "") {
            return AppResponse.paramError("购物车编号参数缺失!");
        }
        if (null == addShoppingCart.getUserCode() || addShoppingCart.getUserCode() == "") {
            return AppResponse.paramError("用户编号参数缺失!");
        }
        //如果修改此购物车商品数量为0.那么直接删除购物车对应的购物车编号
        if (addShoppingCart.getGoodsNum() == 0) {
            int result = shoppingCartDao.deleteCartGood(addShoppingCart);
            if (result > 0) {
                return AppResponse.success( "删除购物车对应商品成功!");
            }
            return AppResponse.paramError("删除购物车对应商品失败!");
        }
        //判断 该商品的库存数量 是否 大于 待修改的商品数量
        int saveLibGood = shoppingCartDao.checkGoodNumEnough(shoppingCartDao.findGoodCodeFromCart(addShoppingCart));
        if (saveLibGood < addShoppingCart.getGoodsNum()) {
            return AppResponse.paramError("该商品库存不足!仅剩余" + saveLibGood + "件,无法购买" + addShoppingCart.getGoodsNum() + "件");
        }
        //修改购物车此种商品数量
        int result = shoppingCartDao.updateCartGood(addShoppingCart);
        //结果
        if (result > 0) {
            return AppResponse.success( "修改数量成功!");
        }
        return AppResponse.paramError("修改购物车商品数量失败!");
    }

    /**
     * 购物车商品删除
     * @param addShoppingCart
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCartGoods(AddShoppingCart addShoppingCart){
        if (null == addShoppingCart.getCartCode() || addShoppingCart.getCartCode() == "") {
            return AppResponse.paramError("购物车编号参数缺失!");
        }
        List<String> cartCodeList = Arrays.asList(addShoppingCart.getCartCode().split(","));
        int result = shoppingCartDao.deleteCartGoodNum(cartCodeList,addShoppingCart.getUserCode());
        if(result > 0){
            return AppResponse.success( "删除成功!数量:"+result);
        }
       return AppResponse.paramError("删除失败!");
    }

    /**
     * 购物车列表查询
     * @param cartGoodUserParam
     * @return
     */
    public AppResponse queryShoppingCartList(CartGoodUserParam cartGoodUserParam){
        //判断参数是否齐全
        if (null == cartGoodUserParam.getUserCode() || cartGoodUserParam.getUserCode() == "") {
            return AppResponse.paramError("用户编号参数缺失!");
        }
        //查询列表
        PageHelper.startPage(cartGoodUserParam.getPageNum(),cartGoodUserParam.getPageSize());
        List<CartGoodList>cartGoodLists = shoppingCartDao.queryShoppingCartList(cartGoodUserParam);
        PageInfo<CartGoodList>cartGoodListPageInfo = new PageInfo<>(cartGoodLists);
        //结果
        if(cartGoodLists.size() > 0){
            return AppResponse.success( "查询成功!", cartGoodListPageInfo);
        }
        return AppResponse.paramError("获取为空!");
    }

}
