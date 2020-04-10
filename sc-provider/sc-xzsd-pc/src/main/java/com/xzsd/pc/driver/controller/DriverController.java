package com.xzsd.pc.driver.controller;


import com.xzsd.pc.driver.entity.Driver;
import com.xzsd.pc.driver.entity.DriverListParamter;
import com.xzsd.pc.driver.entity.UpdateDriver;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private ResponceData responceData;
    @Resource
    private DriverService driverService;
    @ResponseBody

    /**
     * 司机信息新增
     * zhc
     * 2020年4月8日11:00:02
     */
    @PostMapping("addDriver")

    public ResponceData addDriver(Driver driver){
        try{
            return driverService.addDriver(driver);

        }catch (Exception e){
            throw  e;
        }
    }

    /**
     * 司机信息修改
     * @param updateDriver
     * @return
     */
    @PostMapping("updateDriver")
    public ResponceData updateDriver(UpdateDriver updateDriver){
        try{
            return driverService.updateDriver(updateDriver);

        }catch (Exception e){
            throw  e;
        }
    }

    /**
     * 批量删除司机
     * @param updateDriver
     * @return
     */
    @PostMapping("deleteDriver")
    public ResponceData deleteDriver(UpdateDriver updateDriver){
        try{
            return driverService.deleteDriver(updateDriver);

        }catch (Exception e){
            throw  e;
        }
    }

    /**
     * 司机信息详情查询
     * @param updateDriver
     * @return
     */
    @PostMapping("queryDriverDetail")
    public ResponceData queryDriverDetail(UpdateDriver updateDriver){
        try{
            return driverService.queryDriverDetail(updateDriver);

        }catch (Exception e){
            throw  e;
        }
    }

    /**
     * 司机信息列表查询
     * @param updateDriver
     * @return
     */
    @PostMapping("queryDriversList")
    public ResponceData queryDriversList(DriverListParamter updateDriver){
        try{
            return driverService.queryDriversList(updateDriver);
        }catch (Exception e){
            throw  e;
        }
    }
}
