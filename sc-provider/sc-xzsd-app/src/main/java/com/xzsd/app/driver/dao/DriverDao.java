package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 司机app端 dao
 */
@Mapper
public interface DriverDao {
    /**
     * 司机列表信息查询
     * @param code
     * @return
     */
    List<Driver>queryDriverList(@Param("storeCode")String code);
}