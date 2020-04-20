package com.xzsd.pc.store.dao;


import com.xzsd.pc.store.entity.QueryUserStore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xzsd.pc.store.entity.Dict;
import com.xzsd.pc.store.entity.Store;
import com.xzsd.pc.store.entity.StoreListQueryEntity;

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
    int count(@Param("storeName") String storeName, @Param("storeBusinessLicense") String storeBusinessLicense,
              @Param("storeCode")String storeCode);

    /**
     * 查询用户编号是否存在
     * @param queryUserStore
     * @return
     */
    int countStoreUserCode(QueryUserStore queryUserStore);
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

    /**
     * 查询商家信息列表
     * @param queryUserStore
     * @return
     */
    List<QueryUserStore>queryUserStore(QueryUserStore queryUserStore);
}
