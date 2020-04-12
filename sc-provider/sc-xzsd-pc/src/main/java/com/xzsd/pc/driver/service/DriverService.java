package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.*;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 司机
 */
@Service
public class DriverService {
    private ResponceData responceData;
    @Resource
    private DriverDao driverDao;
    /**
     * 新增司机
     * @param driver
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addDriver(Driver driver){
        //判断参数是否齐没
        if(null == driver.getDriverName() || driver.getDriverName() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机名字为空！",null);
        }
        if(null == driver.getDriverAcct() || driver.getDriverAcct() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机账号为空！",null);
        }
        if(null == driver.getDriverPhone() || driver.getDriverPhone() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机电话为空！",null);
        }
        if(null == driver.getDriverPass() || driver.getDriverPass() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机密码为空！",null);
        }
        if(null == driver.getDriverIdCard() || driver.getDriverIdCard() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机身份证号为空！",null);
        }
        if(null == driver.getDriverProvincCode() || driver.getDriverProvincCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机所在省编号为空！",null);
        }
        if(null == driver.getDriverCityCode() || driver.getDriverCityCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机所在市编号为空！",null);
        }
        if(null == driver.getDriverDistinctCode() || driver.getDriverDistinctCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机所在区为空！",null);
        }
        //判断是否已经含有司机账号、司机身份证号
        if( driverDao.countDriverAcct(driver.getDriverAcct(),null) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机账号已经存在！",null);
        }
        //身份证
        if( driverDao.countDriverAcct(null,driver.getDriverIdCard()) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机身份证已经存在！",null);
        }
        //给司机随机生成编号
        driver.setDriverCode(RandomCode.radmonkey());
        //密码md5加密,后面再说
        //新增
        int result = driverDao.addDriver(driver);
        //结果
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"新增成功！",result);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"新增失败！",result);
    }

    /**
     * 司机信息修改
     * @param updateDriver
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateDriver(UpdateDriver updateDriver){
        //判断参数是否齐全
        if(null == updateDriver.getDriverCode() || updateDriver.getDriverCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机编号不能为空！",null);
        }
        if(null == updateDriver.getDriverName() || updateDriver.getDriverName() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机名字不能为空！",null);
        }
        if(null == updateDriver.getDriverPhone() || updateDriver.getDriverPhone() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机电话不能为空！",null);
        }
        if(null == updateDriver.getDriverAcct() || updateDriver.getDriverAcct() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机账号不能为空！",null);
        }
        if(null == updateDriver.getDriverPass() || updateDriver.getDriverPass() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机密码不能为空！",null);
        }
        if(null == updateDriver.getDriverIdCard() || updateDriver.getDriverIdCard() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机身份证号不能为空！",null);
        }
        if(null == updateDriver.getDriverProvincCode() || updateDriver.getDriverProvincCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机省编号不能为空！",null);
        }
        if(null == updateDriver.getDriverCityCode() || updateDriver.getDriverCityCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机市区编号不能为空！",null);
        }
        if(null == updateDriver.getDriverDistinctCode() || updateDriver.getDriverDistinctCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机区编号不能为空！",null);
        }
        String msg = "";
        if(null == updateDriver.getVersion() || updateDriver.getVersion() == ""){
            msg = "版本号没有传值或者为0，可能会导致修改失败!";
        }
        //判断是否已经含有司机账号、司机身份证号
        if( driverDao.countDriverAcct(updateDriver.getDriverAcct(),null) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机账号已经存在！",null);
        }
        //身份证
        if( driverDao.countDriverAcct(null,updateDriver.getDriverIdCard()) > 0 ){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机身份证已经存在！",null);
        }
        //修改
        int result = driverDao.updateDriver(updateDriver);
        //结果
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"修改成功！",result);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"修改失败！"+msg,result);
    }

    /**
     * 司机信息删除
     * @param updateDriver
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteDriver(UpdateDriver updateDriver){
        //判断
        if(null == updateDriver.getDriverCode() || updateDriver.getDriverCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机编号不能为空！",null);
        }
        List<String> listCodes = Arrays.asList(updateDriver.getDriverCode().split(","));
        if(listCodes.size() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"编号不能为空！",null);
        }
        //删除
        int result = driverDao.deleteDriver(listCodes,updateDriver.getUpdateUser());
        //结果
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功！",result);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"删除失败！",result);
    }

    /**
     * 司机信息详情查询
     * @param updateDriver
     * @return
     */
    public ResponceData queryDriverDetail(UpdateDriver updateDriver){
        if(null == updateDriver.getDriverCode() || updateDriver.getDriverCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机编号不能为空！",null);
        }
        DriverDetail driverDetail = driverDao.queryDriverDetail(updateDriver.getDriverCode());
        if(null != driverDetail ){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功！",driverDetail);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询失败！",null);
    }


    /**
     * 司机信息列表查询
     * @param driver
     * @return
     */
    public ResponceData queryDriversList(DriverListParamter driver){
        //判断
        if(driver.getPageSize() == 0 || driver.getPageNum() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"页号或者页数量参数不能为空!",null);
        }
        //查找
        PageHelper.startPage(driver.getPageNum(),driver.getPageSize());
        List<DriverListParamter>driverLists = driverDao.dqueryDriverList(driver);
        PageInfo<DriverListParamter>driverListPageInfo = new PageInfo<>(driverLists);
        //结果
        if(driverLists.size()>0){
          return responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",driverListPageInfo);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空！",null);
    }
}
