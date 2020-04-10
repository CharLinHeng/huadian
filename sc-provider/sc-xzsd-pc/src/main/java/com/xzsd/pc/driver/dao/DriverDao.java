package com.xzsd.pc.driver.dao;


import com.xzsd.pc.driver.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DriverDao {

    /**
     * 司机信息新增
     * @param driver
     * @return
     */
    int addDriver(Driver driver);

    /**
     * 判断是否有已经存在的账号还有身份证
     * @param acct
     * @param idCard
     * @return
     */
    int countDriverAcct(@Param("driverAcct")String acct,@Param("driverIdCard")String idCard);

    /**
     * 司机信息修改
     * @param updateDriver
     * @return
     */
    int updateDriver(UpdateDriver updateDriver);

    /**
     * 机信息删除
     * @param updateDriverList
     * @param updateUser
     * @return
     */
    int deleteDriver(@Param("listCodes") List<String>updateDriverList, @Param("updateUser")String updateUser);


    /**
     * 司机信息详情查询
     * @param driverCode
     * @return
     */
    DriverDetail queryDriverDetail(@Param("driverCode")String driverCode);


    /**
     * 机信息列表查询
     * @param driverListParamter
     * @return
     */

    List<DriverListParamter>dqueryDriverList(DriverListParamter driverListParamter);



}
