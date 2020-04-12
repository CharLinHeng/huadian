package com.xzsd.pc.hotGoodManage.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import com.xzsd.pc.hotGoodManage.dao.HotGoodDao;
import com.xzsd.pc.hotGoodManage.entity.*;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Service
public class HotGoodService {
    private ResponceData responceData;
    @Resource
    private HotGoodDao hotGoodDao;
    /**
     * 热门商品位新增
     * @param hotGood
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addHotGood(HotGood hotGood) {
        if(null == hotGood.getGoodCode() || hotGood.getGoodCode()==""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"商品编号参数需指定",null);
        }
        if(hotGood.getHotGoodSort() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"位排序需指定在大于0",null);
        }
        //增加之前，查看商品的未排序是否已经存在
        if(hotGoodDao.countSort(hotGood.getHotGoodSort()) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"位排序已经存在!",null);
        }
        //增加
        hotGood.setHotGoodCode(RandomCode.radmonkey());
        int result = hotGoodDao.addHotGood(hotGood);
        if( result > 0 ){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"新增成功!",null);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"新增失败!",null);
        }
    }

    /**
     * 热门商品位新增之商品列表查询
     * @param httpServletRequestrequest
     * @return
     */
    public ResponceData queryGoodsList(HttpServletRequest httpServletRequestrequest, HotGoodQuery hotGoodQuery){
        //判断是否有参数
        if(null == httpServletRequestrequest.getParameter("pageNum") || httpServletRequestrequest.getParameter("pageNum") =="" || Integer.parseInt(httpServletRequestrequest.getParameter("pageNum")) == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"分页号不能为空或者为0!",null);
        }
        if(null == httpServletRequestrequest.getParameter("pageSize") || httpServletRequestrequest.getParameter("pageSize") =="" || Integer.parseInt(httpServletRequestrequest.getParameter("pageSize")) == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"分页显示数量不能为空或者为0!",null);
        }
        //查询
        PageHelper.startPage(Integer.parseInt(httpServletRequestrequest.getParameter("pageNum")),Integer.parseInt(httpServletRequestrequest.getParameter("pageSize")));
        //设置
        List<HotGoodQuery> hotGoodQueryList = hotGoodDao.queryGoodsList(hotGoodQuery.getGoodName(),hotGoodQuery.getGoodCode());
        PageInfo<HotGoodQuery>hotGoodQueryPageInfo = new PageInfo<>(hotGoodQueryList);
        if(hotGoodQueryList.size() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询结果为空!",null);
        }
        return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功",hotGoodQueryPageInfo);
    }

    /**
     *  热门商品位修改
     * @param hotGood
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateHotGood(HotGood hotGood){
        //判断参数
        if(null == hotGood.getHotGoodCode() || hotGood.getHotGoodCode() ==""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"热们商品编号不能为空!",null);
        }
        if(null == hotGood.getGoodCode() || hotGood.getGoodCode() ==""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"商品编号不能为空!",null);
        }
        if(hotGood.getHotGoodSort() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"缺失热门商品位排序参数!",null);
        }
        //检查 位排序是否已经存在
        if(hotGoodDao.countSort(hotGood.getHotGoodSort())>0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"位排序已经存在!",null);
        }
        String msg = "";
        if(null == hotGood.getVersion() || hotGood.getVersion() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"缺失版本号参数!",null);
        }
        //修改
        int result = hotGoodDao.updateHotGood(hotGood);
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"修改成功!",null);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"修改失败!",null);
        }
    }

    /**
     * 热门商品位删除
     * @param hotGood
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteHotGood(HotGood hotGood){
        if(null == hotGood.getHotGoodCode() || hotGood.getHotGoodCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"热门编号参数为空!",null);
        }
        List<String>stringList = Arrays.asList(hotGood.getHotGoodCode().split(","));
        if(stringList.size() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"待删除的数量为空",null);
        }
        int result = hotGoodDao.deleteHotGood(stringList,hotGood.getUpdateUser());
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功!",result);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"删除失败!",result);
        }
    }

    /**
     * 热门商品位展示数量
     * @param showNum
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData showHotGoodsNum(ShowNum showNum){
        if(showNum.getHotGoodNum() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"数量不能为空",null);
        }
        showNum.setId(RandomCode.radmonkey());
        int result = hotGoodDao.showHotGoodsNum(showNum);
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"更改成功!",result);
        }
        else{
            return new ResponceData(ResponceDataState.values()[0].getCode(),"更改失败",result);
        }
    }

    /**
     * 热门商品位列表查询
     * @param hotGoodList
     * @return
     */
    public ResponceData queryHotGoodsList(HotGoodList hotGoodList, HttpServletRequest httpServletRequest){
        if(null == httpServletRequest.getParameter("pageNum") || httpServletRequest.getParameter("pageNum") == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"页号不能为空",null);
        }
        if(null == httpServletRequest.getParameter("pageSize") || httpServletRequest.getParameter("pageSize") =="" || Integer.parseInt(httpServletRequest.getParameter("pageSize")) == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"分页显示数量不能为空或者为0!",null);
        }
        PageHelper.startPage(Integer.parseInt(httpServletRequest.getParameter("pageNum")),Integer.parseInt(httpServletRequest.getParameter("pageSize")));
        List<HotGoodList>hotGoodLists = hotGoodDao.queryHotGoodsList(hotGoodList);
        PageInfo<HotGoodList>hotGoodListPageInfo = new PageInfo<>(hotGoodLists);
        if(hotGoodLists.size() == 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询为空!",null);
        }
        else{
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",hotGoodListPageInfo);
        }
    }

    /**
     *  热门商品位详情
     * @param hotGood
     * @return
     */
    public ResponceData queryHotGoodDetail(HotGood hotGood){
        if(null == hotGood.getHotGoodCode() || hotGood.getHotGoodCode() ==""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"编号不能为空",null);
        }
        HotGoodDetail hotGoodDetail = hotGoodDao.queryHotGoodDetail(hotGood.getHotGoodCode());
        if(null == hotGoodDetail){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空",null);
        }
        else{
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功",hotGoodDetail);
        }
    }
}
