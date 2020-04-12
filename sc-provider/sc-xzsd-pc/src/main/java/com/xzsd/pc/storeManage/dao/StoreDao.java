package com.xzsd.pc.storeManage.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xzsd.pc.storeManage.entity.Dict;
import com.xzsd.pc.storeManage.entity.Store;
import com.xzsd.pc.storeManage.entity.StoreListQueryEntity;

import java.util.List;

@Mapper
public interface StoreDao {


    /**
     * 新增门店
     * @param store
     * @return
     */
    int addStore(Store store);

    /**
     * 计数器
     * @param storeName
     * @param storeBusinessLicense
     * @return
     */
    int count(@Param("storeName") String storeName, @Param("storeBusinessLicense") String storeBusinessLicense);

    /**
     * 省
     * @return
     */
    List<Dict>queryProvince();

    /**
     * 市区数据
     * @param code
     * @return
     */
    List<Dict>queryCityOrDistrict(@Param("dictCode") String code);


    /**
     * 门店信息修改
     * @param store
     * @return
     */
    int updateStore(Store store);


    /**
     * 门店删除
     * @param stringList
     * @param updateUser
     * @return
     */
    int deleteStore(@Param("listCodes") List<String> stringList, @Param("updateUser") String updateUser);

    /**
     * 门店信息详情
     * @param store
     * @return
     */
    Store queryStoreDetail(Store store);


    /**
     * 门店信息列表查询
     * @param storeListQueryEntity
     * @return
     */
    List<StoreListQueryEntity>queryStoreList(StoreListQueryEntity storeListQueryEntity);
}
