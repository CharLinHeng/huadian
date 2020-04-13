package com.xzsd.pc.goods.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.entity.GoodList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.xzsd.pc.goods.dao.GoodDao;
import com.xzsd.pc.goods.entity.Good;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
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
        Good goodOut = goodDao.queryDetail(good);
        if(null !=goodOut){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",goodOut);
            return responceData;
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
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
        int countGood_name = goodDao.countGood(good.getGoodName());
        System.out.println(countGood_name);
        if(countGood_name>0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"商品名称已存在！",null);
        }
        //查询商品书号是否已经存在
        int countGoodBookSIzeNum = goodDao.countGoodBookSize(good.getGoodIsbnBookSize());
        if(countGoodBookSIzeNum>0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"商品书号已存在！",null);
        }
        //新增 ,先获取编号
        String goodCode = RandomCode.radmonkey();
        good.setGoodCode(goodCode);
        //如果商品图片地址没有，那么设置默认图片地址
        if(null == good.getGoodImageUrl() || good.getGoodImageUrl() == ""){
            good.setGoodImageUrl(RandomCode.defaultImageUrl());
        }
        int result = goodDao.addGood(good);
        if(result>0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"新增成功!",result);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"新增失败!",result);
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
        //删除商品的时候，需要删除对应的轮播图和热热门商品编号
        String msg = "";
        int deleteTurns = goodDao.deleteTurns(listCodes);
        int deleteHotGoods = goodDao.deleteHotGoods(listCodes);
        if(deleteTurns > 0){
            msg = "已删除对应的轮播图"+deleteTurns+"个";
        }
        if(deleteHotGoods > 0){
            msg = msg + "已删除对应的热门商品"+deleteHotGoods+"个";
        }
        if(result > 0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功!"+msg,result);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"删除失败!",result);
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
        return new ResponceData(ResponceDataState.values()[3].getCode(),"修改失败!",result);
    }

    /**
     * 查询商品列表
     * author:zhc
     * 2020年3月26日16:44:06
     * @param good
     * @return
     */
    public ResponceData queryGoodList(Good good){
        if(good.getPageNum() ==0 || good.getPageSize() == 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"页号参数不能为空!",null);
        }
        //分页
        PageHelper.startPage(good.getPageNum(),good.getPageSize());
        List<GoodList> goodsList = goodDao.queryGoodList(good);
        PageInfo<GoodList> pageData = new PageInfo<GoodList>(goodsList);
        if(pageData.getTotal() > 0 ){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",pageData);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询失败!",null);
    }
    /**
     * 商品修改状态
     * @param good
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateGoodState(Good good,String updateUser){
        if(null == good.getGoodCode()){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"商品编号参数为空",null);
        }
        List<String>goodCodeList = Arrays.asList(good.getGoodCode().split(","));
        int result = goodDao.updateGoodState(goodCodeList,updateUser,good.getGoodState());
        if(result > 0){
           return new ResponceData(ResponceDataState.values()[0].getCode(),"修改状态成功!",result);
        }
        return responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"修改状态失败!",null);
    }
}
