package com.xzsd.app.order.service;

import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.AddOrder;
import com.xzsd.app.order.entity.GoodBigThanLibs;
import com.xzsd.app.order.entity.GoodsExpired;
import com.xzsd.app.util.RandomCode;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     *  订单新增
     * @param addOrder
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addUserOrder(AddOrder addOrder){
        //判断参数是否齐全
        if(null == addOrder.getCartCode() || addOrder.getCartCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"购物车编号为空",null);
        }
        if(null == addOrder.getUserCode() || addOrder.getUserCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"用户编号为空",null);
        }
        List<String>cartCodeList = Arrays.asList(addOrder.getCartCode().split(","));
        String msg = "";
        //生成随机编号
        addOrder.setOrderCode(RandomCode.radmonkey());
        //新增订单
        int result = orderDao.addUserOrder(addOrder);
        if(result > 0){
            msg = "新建订单成功!";
            //清空购物车
            int empty = orderDao.clearEmpty(addOrder);
            if(empty > 0){
                msg = msg + "已清空购物车!";
            }
            //查询有没有商品已经下架,返回已经下架的 购物车编号  已下架的商品无法购买
            List<GoodsExpired> goodsOnShelves = orderDao.goodsExpired(cartCodeList);
            //将CartCodeList去除已过期的商品
            List<String>newCartCodeList = new ArrayList<>();
            boolean con;
            for(int i = 0; i < cartCodeList.size() ;i++){
                con = true;
                for(int j = 0;j < goodsOnShelves.size();j++){
                    if(goodsOnShelves.get(j).equals(cartCodeList.get(i))){
                        con = false;
                    }
                }
                if(con == true){
                    //说明是不过期的商品，则保留
                    newCartCodeList.add(cartCodeList.get(i));
                }
            }
            cartCodeList = newCartCodeList;
            //接下来，判断购物车中 其 每种商品的数量库存 是否 大于等于 购物车中的 每种商品数量 返回的是那些不符合数量的商品编号
            List<GoodBigThanLibs> nonConformingProducts = orderDao.judgementStock(cartCodeList);
            if(nonConformingProducts.size() > 0){
                //将那些购物车的数量修改为当前商品库存的库存的最大数量，如果商品数量库存当前为0，则不替换。
                orderDao.updateGoodNum(cartCodeList);
            }
            //默认支付成功 生成订单后， 需要10分钟之内进行支付，否则 订单删除，商品库存恢复，如果支付成功，那么将纪录添加到顾客表
            //新增到 订单商品列表
            int finalStep = 0;
        }
        //判断结果
        return new ResponceData(ResponceDataState.values()[3].getCode(),"新增订单失败",null);
    }
}
