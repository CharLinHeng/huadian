package com.xzsd.pc.hotGood.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import org.springframework.stereotype.Service;
import com.xzsd.pc.hotGood.dao.HotGoodDao;
import com.xzsd.pc.hotGood.entity.*;
import com.xzsd.pc.util.RandomCode;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
/**
 * @DescriptionDemo 热门商品服务类
 * @Author zhonghecheng
 * @Date 2020-03-30
 */
@Service
public class HotGoodService {
    @Resource
    private HotGoodDao hotGoodDao;
    /**
     * 热门商品位新增
     * @param hotGood
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGood(HotGood hotGood) {
        if(null == hotGood.getGoodCode() || hotGood.getGoodCode()==""){
            
            return AppResponse.paramError("商品编号参数需指定");
        }
        if(hotGood.getHotGoodSort() == 0){
            return AppResponse.paramError("位排序需指定在大于0");
        }
        //增加之前，查看商品的未排序是否已经存在
        if(hotGoodDao.countSort(hotGood.getHotGoodSort(),null) > 0 ){
            return AppResponse.paramError("位排序已经存在!");
        }
        //判断是否已经被选择
        if(hotGoodDao.countGoodIsSelecter(hotGood.getGoodCode(),null)>0){
            return AppResponse.paramError("商品已经被选择!");
        }
        //增加
        hotGood.setHotGoodCode(RandomCode.radmonkey());
        int result = hotGoodDao.addHotGood(hotGood);
        if( result > 0 ){
            return AppResponse.success("新增成功!");
        }
        return AppResponse.bizError("新增失败!");
    }

    /**
     * 热门商品位新增之商品列表查询
     * @param httpServletRequestrequest
     * @return
     */
    public AppResponse queryGoodsList(HttpServletRequest httpServletRequestrequest, HotGoodQuery hotGoodQuery){
        //判断前端是否有参数传过来
        if(null == httpServletRequestrequest.getParameter("pageNum") || httpServletRequestrequest.getParameter("pageNum") ==""
                || Integer.parseInt(httpServletRequestrequest.getParameter("pageNum")) == 0){
            return AppResponse.paramError("分页号不能为空或者为0!");
        }
        if(null == httpServletRequestrequest.getParameter("pageSize") || httpServletRequestrequest.getParameter("pageSize") ==""
                || Integer.parseInt(httpServletRequestrequest.getParameter("pageSize")) == 0){
            return AppResponse.paramError("分页显示数量不能为空或者为0!");
        }
        //查询
        PageHelper.startPage(Integer.parseInt(httpServletRequestrequest.getParameter("pageNum")),
                Integer.parseInt(httpServletRequestrequest.getParameter("pageSize")));
        //设置
        List<HotGoodQuery> hotGoodQueryList = hotGoodDao.queryGoodsList(hotGoodQuery.getGoodName(),hotGoodQuery.getGoodCode());
        PageInfo<HotGoodQuery>hotGoodQueryPageInfo = new PageInfo<>(hotGoodQueryList);
        if(hotGoodQueryList.size() == 0){
            return AppResponse.paramError("查询结果为空!");
        }
        return AppResponse.success("查询成功",hotGoodQueryPageInfo);
    }

    /**
     *  热门商品位修改
     * @param hotGood
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGood(HotGood hotGood){
        //判断参数
        if(null == hotGood.getHotGoodCode() || hotGood.getHotGoodCode() ==""){
            return AppResponse.paramError("热们商品编号不能为空!");
        }
        if(null == hotGood.getGoodCode() || hotGood.getGoodCode() ==""){
            return AppResponse.paramError("商品编号不能为空!");
        }
        if(hotGood.getHotGoodSort() == 0){
            return AppResponse.paramError("缺失热门商品位排序参数!");
        }
        //检查 位排序是否已经存在
        if(hotGoodDao.countSort(hotGood.getHotGoodSort(),hotGood.getHotGoodCode())>0){
            return AppResponse.paramError("位排序已经存在!");
        }
        //判断是否已经被选择,除了自己本身
        if(hotGoodDao.countGoodIsSelecter(hotGood.getGoodCode(),hotGood.getHotGoodCode())>0){
            return AppResponse.paramError("商品已经被选择!");
        }
        if(null == hotGood.getVersion() || hotGood.getVersion() == ""){
            return AppResponse.paramError("缺失版本号参数!");
        }
        //修改
        int result = hotGoodDao.updateHotGood(hotGood);
        if(result > 0){
            return AppResponse.success("修改成功!");
        }
        return AppResponse.bizError("修改失败!");
    }

    /**
     * 热门商品位删除
     * @param hotGood
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGood(HotGood hotGood){
        if(null == hotGood.getHotGoodCode() || hotGood.getHotGoodCode() == ""){
            return AppResponse.paramError("热门编号参数为空!");
        }
        List<String>stringList = Arrays.asList(hotGood.getHotGoodCode().split(","));
        if(stringList.size() == 0){
            return AppResponse.paramError("待删除的数量为空");
        }
        int result = hotGoodDao.deleteHotGood(stringList,hotGood.getUpdateUser());
        if(result > 0){
            return AppResponse.success("删除成功!",result);
        }
        return AppResponse.bizError("删除失败!");
    }

    /**
     * 热门商品位展示数量
     * @param showNum
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse showHotGoodsNum(ShowNum showNum){
        if(showNum.getHotGoodNum() == 0){
            return AppResponse.paramError("数量不能为空");
        }
        showNum.setId(RandomCode.radmonkey());
        int result = hotGoodDao.showHotGoodsNum(showNum);
        if(result > 0){
            return AppResponse.success("更改成功!",result);
        }
        return AppResponse.bizError("更改失败");
    }

    /**
     * 热门商品位列表查询
     * @param hotGoodList
     * @return
     */
    public AppResponse queryHotGoodsList(HotGoodList hotGoodList, HttpServletRequest httpServletRequest){
        if(null == httpServletRequest.getParameter("pageNum") || httpServletRequest.getParameter("pageNum") == ""){
            return AppResponse.paramError("页号不能为空");
        }
        if(null == httpServletRequest.getParameter("pageSize") || httpServletRequest.getParameter("pageSize") =="" || Integer.parseInt(httpServletRequest.getParameter("pageSize")) == 0){
            return AppResponse.paramError("分页显示数量不能为空或者为0!");
        }
        PageHelper.startPage(Integer.parseInt(httpServletRequest.getParameter("pageNum")),Integer.parseInt(httpServletRequest.getParameter("pageSize")));
        List<HotGoodList>hotGoodLists = hotGoodDao.queryHotGoodsList(hotGoodList);
        PageInfo<HotGoodList>hotGoodListPageInfo = new PageInfo<>(hotGoodLists);
        if(hotGoodLists.size() == 0){
            return AppResponse.paramError("查询为空!");
        }
        return AppResponse.success("查询成功!",hotGoodListPageInfo);
    }

    /**
     *  热门商品位详情
     * @param hotGood
     * @return
     */
    public AppResponse queryHotGoodDetail(HotGood hotGood){
        if(null == hotGood.getHotGoodCode() || hotGood.getHotGoodCode() ==""){
            return AppResponse.paramError("编号不能为空");
        }
        HotGoodDetail hotGoodDetail = hotGoodDao.queryHotGoodDetail(hotGood.getHotGoodCode());
        if(null == hotGoodDetail){
            return AppResponse.paramError("查询为空");
        }
        return AppResponse.success("查询成功",hotGoodDetail);
    }
}
