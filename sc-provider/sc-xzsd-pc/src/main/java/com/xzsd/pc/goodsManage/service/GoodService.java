package com.xzsd.pc.goodsManage.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.xzsd.pc.goodsManage.dao.GoodDao;
import com.xzsd.pc.goodsManage.entity.Good;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import javax.jms.Destination;
//import javax.jms.Queue;
//import javax.jms.Topic;

/**
 * @DescriptionDemo 商品管理服务
 * @Author zhc
 * @Date 2020年3月26日10:30:49
 */
@Service
@Component
public class GoodService {
    @Resource

    private GoodDao goodDao;
    private ResponceData responceData;
    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     *商品详情查询
     * zhc
     * 2020年3月26日11:03:08
     */
    public ResponceData queryGoodDetail(Good good){
        Good good1 = goodDao.queryDetail(good);
        if(null !=good1){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功",good1);
            return responceData;
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"商品不存在",null);
            return responceData;
        }
    }
    /**
     *商品增加
     * zhc
     * 2020年3月26日10:31:06
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addGood(Good good){
        //查询商品名称是否存在
        int countGood_name = goodDao.countGood(good.getGood_name());
        System.out.println(countGood_name);
        if(countGood_name>0){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"商品名称已存在！",null);
            return responceData;
        }
        //查询商品书号是否已经存在
        int countGoodBookSIzeNum = goodDao.countGoodBookSize(good.getGood_isbn_bookSize());
        if(countGoodBookSIzeNum>0){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"商品书号已存在！",null);
            return responceData;
        }
        //新增 ,先获取编号
        String goodCode = RandomCode.radmonkey();
        good.setGood_code(goodCode);
        //如果商品图片地址没有，那么设置默认图片地址
        if(null == good.getGood_image_url() || good.getGood_image_url() == ""){
            good.setGood_image_url(RandomCode.defaultImageUrl());
        }
        int result = goodDao.addGood(good);
        if(result>0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"新增成功!",result);
        }else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"新增失败!",result);
        }
        return responceData;
    }
    /**
     *删除商品
     * zhc
     * 2020年3月26日10:31:06
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteGoods(String goodsCode,String updateUserCode){
        List<String> listCodes = Arrays.asList(goodsCode.split(","));
        int result = goodDao.deleteGoods(listCodes,updateUserCode);
        if(result > 0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功!",result);
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"删除失败!",result);
        }
        return responceData;
    }

    /**
     * 修改商品
     * author:zhc
     * 2020年3月26日14:36:29
     * @param good
     * @return
     */
    public ResponceData updateGoo(Good good){
        int result = goodDao.updateGood(good);
        //如果数量
        if(result > 0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"修改成功!",result);
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"修改失败!",result);
        }
        return responceData;
    }

    /**
     * 查询商品列表
     * author:zhc
     * 2020年3月26日16:44:06
     * @param good
     * @return
     */
    public ResponceData queryGoodList(Good good){
        //检查，条件 在 如果在Redis中没有数据，那么就 新增
        //查询的条件
        //拼接条件，如果拼接后条件，从Redis中查询，如果是空的，那么就先从数据库查询，然后往Redis中增加。
        //否则直接从Redis中进行查询并返回。
        String goodName = good.getGood_name();
        String goodState = String.format("%d",good.getGood_state());
        String goodAd = good.getGood_ad();
        String goodCommodityPress = good.getGood_commodity_press();
        String goodAuthor = good.getGood_author();
        String pageSize_queryGood = String.format("%d",good.getPageSize());
        String pageNum_queryGood = String.format("%d",good.getPageNum());
        String keyName = goodName+","+goodState+","+goodAd+","+goodCommodityPress+","+goodAuthor+","+pageNum_queryGood+","+pageSize_queryGood;
        //查询redis中是否有此条件数据
        if(good.getPageNum() ==0 || good.getPageSize() == 0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"页号参数不能为空!",null);
        }
        //分页
        PageHelper.startPage(good.getPageNum(),good.getPageSize());
        List<Good> goodsList = goodDao.queryGoodList(good);
        PageInfo<Good> pageData = new PageInfo<Good>(goodsList);
        if(pageData.getTotal() > 0 ){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",pageData);
        }else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"查询失败!",null);
        }
        return  responceData;
    }
    /**
     * 商品修改状态service
     * @param good
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateGoodState(Good good,String updateUser){
        if(null == good.getGood_code()){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"参数空",null);
            return responceData;
        }
        List<String>goodCodeList = Arrays.asList(good.getGood_code().split(","));
        int result = goodDao.updateGoodState(goodCodeList,updateUser,good.getGood_state());
        if(result > 0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"修改状态成功!",result);
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"修改状态失败!",null);
        }
        return responceData;
    }



}
