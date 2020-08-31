package com.xzsd.pc.store.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.Customer;
import com.xzsd.pc.customer.entity.User;
import com.xzsd.pc.store.entity.QueryUserStore;
import com.xzsd.pc.util.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.Dict;
import com.xzsd.pc.store.entity.Store;
import com.xzsd.pc.store.entity.StoreListQueryEntity;
import com.xzsd.pc.util.RandomCode;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
/**
 * @DescriptionDemo 门店管理服务实现类
 * @Author zhonghecheng
 * @Date 2020-04-01
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;
    @Resource
    private CustomerDao customerDao;
    private static final int SECOND = 2;
    /**
     * 新增门店
     * @param store
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(Store store){
        //判断参数
        if(null == store.getStoreName() || store.getStoreName() == ""){
            return AppResponse.paramError("门店名称不能为空!");
        }
        if(null == store.getStorePhone() || store.getStorePhone() == ""){
            return AppResponse.paramError("联系电话不能为空!");
        }
        if(null == store.getUserCode() || store.getUserCode() == ""){
            return AppResponse.paramError("店长编号不能为空!");
        }
        if(null == store.getStoreBusinessLicense() || store.getStoreBusinessLicense() == ""){
            return AppResponse.paramError("营业执照不能为空!");
        }
        if(null == store.getStoreProvinceCode() || store.getStoreProvinceCode() == ""){
            return AppResponse.paramError("省编号不能为空!");
        }
        if(null == store.getStoreCityCode() || store.getStoreCityCode() == ""){
            return AppResponse.paramError("市区编号不能为空!");
        }
        if(null == store.getStoreDistinctCode() || store.getStoreDistinctCode() == ""){
            return AppResponse.paramError("区编号不能为空!");
        }
        if(null == store.getStoreDetailAddress() || store.getStoreDetailAddress() == ""){
            return AppResponse.paramError("详细地址不能为空!");
        }
        //判断店铺是否已经存在 营业执照
        if(storeDao.count(null,store.getStoreBusinessLicense(),null) > 0 ){
            return AppResponse.paramError("门店营业执照已经存在！");
        }
        //查询门店店长是否存在 用户表里
        QueryUserStore queryUserStore = new QueryUserStore();
        queryUserStore.setUserCode(store.getUserCode());
        if(storeDao.countStoreUserCode(queryUserStore) == 0){
            return AppResponse.paramError("门店商家不存在！");
        }
        //判断该店长是否已经绑定了店铺
        if(storeDao.countUserHasBindStore(store) > 0){
            return AppResponse.bizError("该店长已经绑定了店铺了!");
        }
        //邀请码
        store.setInvestCode(RandomCode.random_GoodClassifiCationCode());
        store.setStoreCode(RandomCode.radmonkey());
        //当前用户
        store.setUpdateUser(SecurityUtils.getCurrentUserUsername());
        //新增
        int result = storeDao.addStore(store);
        if(result > 0){
            return AppResponse.success("新增成功!",result);
        }
        return AppResponse.paramError("新增失败!");
    }
    /**
     * 省数据查询
     * @return
     */
    public AppResponse queryProvince(){
        return AppResponse.success("省数据",storeDao.queryProvince());
    }
    /**
     * 市区查询
     * @param dict
     * @return
     */
    public AppResponse queryCityOrDistrict(Dict dict){
        if(null == dict.getAreaCode() || dict.getAreaCode() == ""){
            return AppResponse.paramError("父级编号需指定");
        }
        List<Dict> dictList = storeDao.queryCityOrDistrict(dict.getAreaCode());
        if(dictList.size() > 0){
            String msg = "区数据";
            if(dictList.get(0).getDictType().equals(SECOND)){
                msg = "市数据";
            }
            return AppResponse.success(msg+"查询成功！",dictList);
        }
        return AppResponse.success("查询为空!");
    }

    /**
     * 门店信息修改
     * @param store
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(Store store){
        //判断
        if(null == store.getStoreCode() || store.getStoreCode() =="" ){
            return AppResponse.paramError("门店编号参数为空!");
        }
        if(null == store.getStoreName() || store.getStoreName() =="" ){
            return AppResponse.paramError("门店名称参数为空!");
        }
        if(null == store.getStorePhone() || store.getStorePhone() =="" ){
            return AppResponse.paramError("联系电话参数为空!");
        }
        if(null == store.getStoreBusinessLicense() || store.getStoreBusinessLicense() =="" ){
            return AppResponse.paramError("营业执照参数为空!");
        }
        if(null == store.getStoreProvinceCode() || store.getStoreProvinceCode() =="" ){
            return AppResponse.paramError("省编号参数为空!");
        }
        if(null == store.getStoreCityCode() || store.getStoreCityCode() =="" ){
            return AppResponse.paramError("市编号参数为空!");
        }
        if(null == store.getStoreDistinctCode() || store.getStoreDistinctCode() =="" ){
            return AppResponse.paramError("区编号参数为空!");
        }
        if(null == store.getStoreDetailAddress() || store.getStoreDetailAddress() =="" ){
            return AppResponse.paramError("详细地址参数为空!");
        }
        if(null == store.getVersion() || store.getVersion() =="" ){
            return AppResponse.paramError("版本号参数为空!");
        }
        //营业执照
        if(storeDao.count(null,store.getStoreBusinessLicense(),store.getStoreCode()) > 0 ){
            return AppResponse.paramError("门店营业执照已经存在！");
        }
        //判断门店店长是否存在这个表里
        QueryUserStore queryUserStore = new QueryUserStore();
        queryUserStore.setUserCode(store.getUserCode());
        if(storeDao.countStoreUserCode(queryUserStore) == 0){
            return AppResponse.paramError("门店商家不存在！");
        }
        //判断该店长是否已经绑定了店铺
        if(storeDao.countUserHasBindStore(store) > 0){
            return AppResponse.bizError("该店长已经绑定了店铺了!");
        }
        //当前用户
        store.setUpdateUser(SecurityUtils.getCurrentUserUsername());
        int result = storeDao.updateStore(store);
        if(result > 0){
            return AppResponse.success("修改成功！",result);
        }
        return AppResponse.paramError("修改失败!");
    }

    /**
     *  门店删除
     * @param store
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(Store store){
        if(null == store.getStoreCode() || store.getStoreCode() == ""){
            return AppResponse.paramError("编号参数为空");
        }
        List<String>stringList = Arrays.asList(store.getStoreCode().split(","));
        int result = storeDao.deleteStore(stringList,store.getUpdateUser());
        if(result > 0){
            return AppResponse.success("删除成功！",result);
        }
        return AppResponse.paramError("删除失败!");
    }
    /**
     *  门店信息详情
     * @param store
     * @return
     */
    public AppResponse queryStoreDetail(Store store){
        if(null == store.getStoreCode() || store.getStoreCode() == ""){
            return AppResponse.paramError("编号参数为空");
        }
        Store store1 = storeDao.queryStoreDetail(store);
        if(null != store1){
            return AppResponse.success("查询成功！",store1);
        }
        return AppResponse.paramError("查询失败!");
    }

    /**
     * 门店信息列表查询
     * @param storeListQueryEntity
     * @param httpServletRequest
     * @return
     */
    public AppResponse queryStoreList(StoreListQueryEntity storeListQueryEntity, HttpServletRequest httpServletRequest){
        //判断参数
        if(null == httpServletRequest.getParameter("pageNum") || httpServletRequest.getParameter("pageNum") == ""
                || Integer.parseInt(httpServletRequest.getParameter("pageNum")) == 0){
            return AppResponse.paramError("页号参数不正确");
        }
        if(null == httpServletRequest.getParameter("pageSize") || httpServletRequest.getParameter("pageSize") == ""
                || Integer.parseInt(httpServletRequest.getParameter("pageSize")) == 0){
            return AppResponse.paramError("页显示数量参数不正确");
        }
        //获取当前用户登入编号
        String userAccount = SecurityUtils.getCurrentUserUsername();
        //查询当前登入用户信息
        User user = customerDao.queryCurrUser(userAccount);
        if(null == user){
            return AppResponse.bizError("司机不可以查看这里的模块");
        }
        storeListQueryEntity.setCurrUserCode(user.getUserCode());
        storeListQueryEntity.setUserRole(user.getUserRole());
        PageHelper.startPage(Integer.parseInt(httpServletRequest.getParameter("pageNum")),
                Integer.parseInt(httpServletRequest.getParameter("pageSize")));
        List<StoreListQueryEntity>listQueryEntities = storeDao.queryStoreList(storeListQueryEntity);
        PageInfo<StoreListQueryEntity>storeListQueryEntityPageInfo = new PageInfo<>(listQueryEntities);
        //判断结果
        if(listQueryEntities.size() > 0){
            return AppResponse.success("查询成功!",storeListQueryEntityPageInfo);
        }
        return AppResponse.paramError("查询为空!");
    }

    /**
     * 新增门店的   商家列表查询
     * @param queryUserStore
     * @param httpServletRequest
     * @return
     */
    public AppResponse queryUserStore(QueryUserStore queryUserStore,HttpServletRequest httpServletRequest){
        int pageSize = 0,pageNum = 0;
        if(null != httpServletRequest.getParameter("pageNum")){
            pageNum = Integer.parseInt(httpServletRequest.getParameter("pageNum"));
        }
        if(null != httpServletRequest.getParameter("pageSize")){
            pageSize = Integer.parseInt(httpServletRequest.getParameter("pageSize"));
        }
        PageHelper.startPage(pageNum,pageSize);
        List<QueryUserStore>queryUserStoreList = storeDao.queryUserStore(queryUserStore);
        PageInfo<QueryUserStore>queryUserStorePageInfo = new PageInfo<>(queryUserStoreList);
        if(queryUserStoreList.size() > 0){
            return AppResponse.success("查询成功!",queryUserStorePageInfo);
        }
        return AppResponse.paramError("查询为空!");
    }
}
