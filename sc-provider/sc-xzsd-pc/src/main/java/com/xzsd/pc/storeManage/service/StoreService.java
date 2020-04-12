package com.xzsd.pc.storeManage.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xzsd.pc.storeManage.dao.StoreDao;
import com.xzsd.pc.storeManage.entity.Dict;
import com.xzsd.pc.storeManage.entity.Store;
import com.xzsd.pc.storeManage.entity.StoreListQueryEntity;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Service
public class StoreService {
    private ResponceData responceData;
    @Resource
    private StoreDao storeDao;
    /**
     * 插入门店
     * @param store
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addStore(Store store){
        //判断参数
        if(null == store.getStoreName() || store.getStoreName() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店名称不能为空!",null);
        }
        if(null == store.getStorePhone() || store.getStorePhone() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"联系电话不能为空!",null);
        }
        if(null == store.getUserCode() || store.getUserCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"店长编号不能为空!",null);
        }
        if(null == store.getStoreBusinessLicense() || store.getStoreBusinessLicense() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"营业执照不能为空!",null);
        }
        if(null == store.getStoreProvinceCode() || store.getStoreProvinceCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"省编号不能为空!",null);
        }
        if(null == store.getStoreCityCode() || store.getStoreCityCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"市区编号不能为空!",null);
        }
        if(null == store.getStoreDistinctCode() || store.getStoreDistinctCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"区编号不能为空!",null);
        }
        if(null == store.getStoreDetailAddress() || store.getStoreDetailAddress() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"详细地址不能为空!",null);
        }
        //判断店铺是否已经存在
        //门店名称
        if(storeDao.count(store.getStoreName(),null) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店名称已经存在！",null);
        }
        //营业执照
        if(storeDao.count(null,store.getStoreBusinessLicense()) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店营业执照已经存在！",null);
        }
        //邀请码
        store.setInvestCode(RandomCode.random_GoodClassifiCationCode());
        store.setStoreCode(RandomCode.radmonkey());
        //插入
        int result = storeDao.addStore(store);
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"新增成功!",result);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"新增失败!",result);
        }
    }

    /**
     * 省数据查询
     * @return
     */
    public ResponceData queryProvince(){
        return new ResponceData(ResponceDataState.values()[0].getCode(),"省数据",storeDao.queryProvince());
    }
    /**
     * 市区查询
     * @param dict
     * @return
     */
    public ResponceData queryCityOrDistrict(Dict dict){
        if(null == dict.getAreaCode() || dict.getAreaCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"父级编号需指定",null);
        }
        List<Dict> dictList = storeDao.queryCityOrDistrict(dict.getAreaCode());
        if(dictList.size() > 0){
            String msg = "";
            if(dictList.get(0).getDictType().equals("2")){
                msg = "市数据";
            }
            else{
                msg = "区数据";
            }
            return new ResponceData(ResponceDataState.values()[3].getCode(),msg+"查询成功！",dictList);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
        }
    }

    /**
     * 门店信息修改
     * @param store
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateStore(Store store){
        //各种判断
        if(null == store.getStoreCode() || store.getStoreCode() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店编号参数为空!",null);
        }
        if(null == store.getStoreName() || store.getStoreName() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店名称参数为空!",null);
        }
        if(null == store.getStorePhone() || store.getStorePhone() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"联系电话参数为空!",null);
        }
        if(null == store.getUserCode() || store.getUserCode() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"店长编号参数为空!",null);
        }
        if(null == store.getStoreBusinessLicense() || store.getStoreBusinessLicense() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"营业执照参数为空!",null);
        }
        if(null == store.getStoreProvinceCode() || store.getStoreProvinceCode() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"省编号参数为空!",null);
        }
        if(null == store.getStoreCityCode() || store.getStoreCityCode() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"市编号参数为空!",null);
        }
        if(null == store.getStoreDistinctCode() || store.getStoreDistinctCode() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"区编号参数为空!",null);
        }
        if(null == store.getStoreDetailAddress() || store.getStoreDetailAddress() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"详细地址参数为空!",null);
        }
        if(null == store.getVersion() || store.getVersion() =="" ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"版本号参数为空!",null);
        }
        //判断 店名称、营业执照
        //门店名称
        if(storeDao.count(store.getStoreName(),null) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店名称已经存在！",null);
        }
        //营业执照
        if(storeDao.count(null,store.getStoreBusinessLicense()) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店营业执照已经存在！",null);
        }
        int result = storeDao.updateStore(store);
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"修改成功！",result);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"修改失败!",null);
        }

    }

    /**
     *  门店删除
     * @param store
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteStore(Store store){
        if(null == store.getStoreCode() || store.getStoreCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"编号参数为空",null);
        }
        List<String>stringList = Arrays.asList(store.getStoreCode().split(","));
        int result = storeDao.deleteStore(stringList,store.getUpdateUser());
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功！",result);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"删除失败!",null);
    }

    /**
     *  门店信息详情
     * @param store
     * @return
     */
    public ResponceData queryStoreDetail(Store store){
        if(null == store.getStoreCode() || store.getStoreCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"编号参数为空",null);
        }
        Store store1 = storeDao.queryStoreDetail(store);
        if(null != store1){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功！",store1);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询失败!",null);
    }

    /**
     * 门店信息列表查询
     * @param storeListQueryEntity
     * @return
     */
    public ResponceData queryStoreList(StoreListQueryEntity storeListQueryEntity, HttpServletRequest httpServletRequest){
        //判断参数
        if(null == httpServletRequest.getParameter("pageNum") || httpServletRequest.getParameter("pageNum") == ""
                || Integer.parseInt(httpServletRequest.getParameter("pageNum")) == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"页号参数不正确",null);
        }
        if(null == httpServletRequest.getParameter("pageSize") || httpServletRequest.getParameter("pageSize") == ""
                || Integer.parseInt(httpServletRequest.getParameter("pageSize")) == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"页显示数量参数不正确",null);
        }
        //开始
        PageHelper.startPage(Integer.parseInt(httpServletRequest.getParameter("pageNum")),Integer.parseInt(httpServletRequest.getParameter("pageSize")));
        List<StoreListQueryEntity>listQueryEntities = storeDao.queryStoreList(storeListQueryEntity);
        PageInfo<StoreListQueryEntity>storeListQueryEntityPageInfo = new PageInfo<>(listQueryEntities);
        //判断结果
        if(listQueryEntities.size() > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",storeListQueryEntityPageInfo);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }
}
