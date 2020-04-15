package com.xzsd.app.driver.controller;

import com.xzsd.app.driver.entity.Driver;
import com.xzsd.app.driver.entity.DriverResponsibleArea;
import com.xzsd.app.driver.entity.Store;
import com.xzsd.app.driver.service.DriverService;
import com.xzsd.app.passWord.entity.PassWord;
import com.xzsd.app.passWord.service.PassWordService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * 司机信息查询类
 */
@RestController
@RequestMapping("/customer")
public class DriverController {
    @Resource
    private DriverService driverService;
    /**
     * 查询司机列表
     * @param driver
     * @return
     */
    @ResponseBody
    @PostMapping("queryDriverList")
    public ResponceData queryDriverList(Driver driver){
        try{
            return driverService.queryDriverList(driver);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 门店详情查询
     * @param store
     * @return
     */
    @PostMapping("queryStoreDetail")
    public ResponceData queryStoreDetail(Store store){
        try{
            return driverService.queryStoreDetail(store);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 司机负责门店查询
     * @param driverResponsibleArea
     * @return
     */
    @PostMapping("queryDriverResponsibleList")
    public ResponceData queryDriverResponsibleList(DriverResponsibleArea driverResponsibleArea){
        try{
            return driverService.queryDriverInformationDetail(driverResponsibleArea);
        }catch (Exception e){
            throw e;
        }
    }
}