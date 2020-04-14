package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.*;
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

    /**
     * 闷蛋信息查询
     * @param storeCode
     * @return
     */
    Store queryStoreDetail(@Param("storeCode")String storeCode);

    /**
     * 查询司机信息详情
     * @return
     */
    DriverVO queryDriverInformationDetail(@Param("driverCode")String driverCode);

    /**
     * 司机负责区域查询
     * @param driverCode
     * @return
     */
    List<DriverResponsibleArea>queryDriverResponsibleList(@Param("driverCode")String driverCode);

    /**
     * 查询省市区对应的名称
     * @return
     */
    List<AreaName>queryPCD(List<DriverResponsibleArea>driverResponsibleAreaList);

}
