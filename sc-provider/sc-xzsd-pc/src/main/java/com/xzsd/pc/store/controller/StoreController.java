package com.xzsd.pc.store.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.store.entity.QueryUserStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.store.entity.Dict;
import com.xzsd.pc.store.entity.Store;
import com.xzsd.pc.store.entity.StoreListQueryEntity;
import com.xzsd.pc.store.service.StoreService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     * @return
     */
    @ResponseBody
    @PostMapping("addStore")
    public AppResponse addStore(Store store){
        try {
            
            return  storeService.addStore(store);
            
        }catch (Exception e){
            throw e;
        }

    }

    /**
     * 省数据查询
     * @return
     */
    @PostMapping("queryProvince")
    public AppResponse queryProvince(){
        try {
            return  storeService.queryProvince();
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 市区数据查询
     * @param dict
     * @return
     */
    @PostMapping("queryCityOrDistrict")
    public AppResponse queryCityOrDistrict(Dict dict){
        try {
            return  storeService.queryCityOrDistrict(dict);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     *  门店信息修改
     * @param store
     * @return
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(Store store){
        try {
            return  storeService.updateStore(store);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     *  门店删除
     * @param store
     * @return
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(Store store){
        try {
            return  storeService.deleteStore(store);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 门店信息详情
     * @param store
     * @return
     */
    @PostMapping("queryStoreDetail")
    public AppResponse queryStoreDetail(Store store){
        try {
            return  storeService.queryStoreDetail(store);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 门店信息列表查询
     * @param storeListQueryEntity
     * @param httpServletRequest
     * @return
     */
    @PostMapping("queryStoreList")
    public AppResponse queryStoreList(StoreListQueryEntity storeListQueryEntity, HttpServletRequest httpServletRequest){
        try {
            return  storeService.queryStoreList(storeListQueryEntity,httpServletRequest);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 门店新增之商家列表查询
     * @param queryUserStore
     * @param httpServletRequest
     * @return
     */
    @PostMapping("queryUserStore")
    public AppResponse queryUserStore(QueryUserStore queryUserStore, HttpServletRequest httpServletRequest){
        try {
            return  storeService.queryUserStore(queryUserStore,httpServletRequest);
        }catch (Exception e){
            throw e;
        }
    }
}
