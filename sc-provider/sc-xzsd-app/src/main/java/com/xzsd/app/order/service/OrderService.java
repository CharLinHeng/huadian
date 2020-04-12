package com.xzsd.app.order.service;

import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.AddOrder;
import com.xzsd.app.order.entity.GoodBigThanLibs;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     *  订单新增
     * @param addOrder
     * @return
     */
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
        //查询有没有商品已经下架,返回已经下架的商品编号
        List<GoodBigThanLibs> goodsOnShelves;
        //判断购物车中 其 每种商品的数量库存 是否 大于等于 购物车中的 每种商品数量
        List<GoodBigThanLibs> nonConformingProducts = orderDao.judgementStock(cartCodeList);
        if(nonConformingProducts.size() > 0){

        }
        //清空购物车

        //新增订单

        //新增到 订单商品列表

        //判断结果 生成订单后， 需要10分钟之内进行支付，否则 订单删除，商品库存恢复，如果支付成功，那么将纪录添加到顾客表
        return new ResponceData(ResponceDataState.values()[3].getCode(),"新增订单失败",null);
    }
}
