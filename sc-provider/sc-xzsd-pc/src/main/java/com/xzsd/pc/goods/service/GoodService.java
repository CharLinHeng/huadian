package com.xzsd.pc.goods.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.entity.User;
import com.xzsd.pc.goods.entity.GoodClassifi;
import com.xzsd.pc.goods.entity.GoodList;
import com.xzsd.pc.util.SecurityUtils;
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
    private final static int SHOPPER = 1;
    /**
     *商品详情查询
     * zhc
     * 2020年3月26日11:03:08
     */
    public AppResponse queryGoodDetail(Good good){
        Good goodOut = goodDao.queryDetail(good);
        if(null != goodOut){
            return AppResponse.success("查询成功!",goodOut);
        }
        return AppResponse.bizError("查询为空!");
    }
    /**
     *商品增加
     * zhc
     * 2020年3月26日10:31:06
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGood(Good good){
        //查询商品名称是否存在
        int countGood_name = goodDao.countGood(good.getGoodName(),null);
        if(countGood_name>0){
            return AppResponse.paramError("商品名称已存在！");
        }
        //查询商品书号是否已经存在
//        int countGoodBookSIzeNum = goodDao.countGoodBookSize(good.getGoodIsbnBookSize(),null);
//        if(countGoodBookSIzeNum>0){
//            return AppResponse.paramError("商品书号已存在！");
//        }
        User roleQuery = goodDao.getUserRole(com.neusoft.security.client.utils.SecurityUtils.getCurrentUserId());
        if(null != roleQuery && roleQuery.getUserRole() == SHOPPER){
            good.setGoodShopCode(roleQuery.getShopCode());
        }else{
            return AppResponse.bizError("该用户没有申请店铺");
        }
        good.setGoodShopCode(roleQuery.getShopCode());
        //新增 ,先获取编号
        String goodCode = RandomCode.radmonkey();
        //获取创建者
        good.setCreateUser(SecurityUtils.getCurrentUserUsername());
        good.setGoodCode(goodCode);
        //如果商品图片地址没有，那么设置默认图片地址

        System.out.println("当前id:"+good.getGoodShopCode());
        if(null == good.getGoodImageUrl() || good.getGoodImageUrl() == ""){
            good.setGoodImageUrl(RandomCode.defaultImageUrl());
        }
        int result = goodDao.addGood(good);
        if(result>0){
            return AppResponse.success("新增成功!",result);
        }
        return AppResponse.bizError("新增失败!,请重试");
    }
    /**
     *删除商品
     * zhc
     * 2020年3月26日10:31:06
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsCode,String updateUserCode){
        List<String> listCodes = Arrays.asList(goodsCode.split(","));
        int result = goodDao.deleteGood(listCodes,updateUserCode);
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
            return AppResponse.success("删除成功!"+msg,result);
        }
        return AppResponse.bizError("删除失败!"+result);
    }
    /**
     * 修改商品
     * author:zhc
     * 2020年3月26日14:36:29
     * @param good
     * @return
     */
    public AppResponse updateGoo(Good good){
        //判断参数
        if(null == good.getGoodCode() || good.getGoodCode() == ""){
            return AppResponse.success("商品编号参数为空!");
        }
        //判断是否重复 除了它自己本身
        int result  = 0;
//        if(result > 0){
//            return AppResponse.paramError("书号已经存在!");
//        }
        //查询商品名称是否存在
//        int countGood_name = goodDao.countGood(good.getGoodName(),good.getGoodCode());
//        if(countGood_name>0){
//            return AppResponse.paramError("商品名称已存在!");
//        }
        good.setUpdateUser(SecurityUtils.getCurrentUserUsername());
        result = goodDao.updateGood(good);
        //如果数量
        if(result > 0){
            return AppResponse.success("修改成功!",result);
        }
        return AppResponse.bizError("修改失败!");
    }

    /**
     * 查询商品列表
     * author:zhc
     * 2020年3月26日16:44:06
     * @param good
     * @return
     */
    public AppResponse queryGoodList(Good good){
        //分页
        //根绝角色id查找这个用户属于什么角色
        User roleQuery = goodDao.getUserRole(com.neusoft.security.client.utils.SecurityUtils.getCurrentUserId());
        if(null != roleQuery && roleQuery.getUserRole() == SHOPPER){
            good.setGoodShopCode(roleQuery.getShopCode());
        }else{
            good.setGoodShopCode("");
        }
        PageHelper.startPage(good.getPageNum(),good.getPageSize());
        List<GoodList> goodsList = goodDao.queryGoodList(good);
        PageInfo<GoodList> pageData = new PageInfo<GoodList>(goodsList);
        if(pageData.getTotal() > 0 ){
            return AppResponse.success("查询成功!",pageData);
        }
        return AppResponse.bizError("查询为空!");
    }
    /**
     * 商品修改状态
     * @param good
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodState(Good good,String updateUser){
        if(null == good.getGoodCode()){
            return AppResponse.success("商品编号参数为空!");
        }
        List<String>goodCodeList = Arrays.asList(good.getGoodCode().split(","));
        int result = goodDao.updateGoodState(goodCodeList,updateUser,good.getGoodState());
        if(result > 0){
            return AppResponse.success("修改状态成功!",result);
        }
        return AppResponse.bizError("修改状态失败!");
    }
    /**
     * 商品一级分类查询
     * @return
     */
    public AppResponse queryFirstClass(){
        List<GoodClassifi>goodClassifiList = goodDao.queryFirstClass();
        return AppResponse.success("查询成功!",goodClassifiList);
    }
    /**
     * 商品二级分类查询
     * @param goodClassifi
     * @return
     */
    public AppResponse querySecondClass(GoodClassifi goodClassifi){
        if(null == goodClassifi.getClassCode() || goodClassifi.getClassCode() == ""){
            return AppResponse.success("父级编号参数未指定!");
        }
        List<GoodClassifi>goodClassifiList = goodDao.querySecondClass(goodClassifi.getClassCode());
        return AppResponse.success("查询成功!",goodClassifiList);
    }
}
