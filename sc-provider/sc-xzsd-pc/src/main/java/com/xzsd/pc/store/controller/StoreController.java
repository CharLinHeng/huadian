package com.xzsd.pc.store.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.store.entity.Dict;
import com.xzsd.pc.store.entity.Store;
import com.xzsd.pc.store.entity.StoreListQueryEntity;
import com.xzsd.pc.store.service.StoreService;
import com.xzsd.pc.util.ResponceData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/store")
public class StoreController {
    private ResponceData responceData;

    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     * @return
     */
    @ResponseBody
    @PostMapping("addStore")
    public ResponceData addStore(Store store){
        try {
            responceData = storeService.addStore(store);
            return responceData;
        }catch (Exception e){
            throw e;
        }

    }

    /**
     * 省数据查询
     * @return
     */
    @PostMapping("queryProvince")
    public ResponceData queryProvince(){
        try {
            responceData = storeService.queryProvince();
            return responceData;
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
    public ResponceData queryCityOrDistrict(Dict dict){
        try {
            responceData = storeService.queryCityOrDistrict(dict);
            return responceData;
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
    public ResponceData updateStore(Store store){
        try {
            responceData = storeService.updateStore(store);
            return responceData;
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
    public ResponceData deleteStore(Store store){
        try {
            responceData = storeService.deleteStore(store);
            return responceData;
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
    public ResponceData queryStoreDetail(Store store){
        try {
            responceData = storeService.queryStoreDetail(store);
            return responceData;
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
    public ResponceData queryStoreList(StoreListQueryEntity storeListQueryEntity, HttpServletRequest httpServletRequest){
        try {
            responceData = storeService.queryStoreList(storeListQueryEntity,httpServletRequest);
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }
}
