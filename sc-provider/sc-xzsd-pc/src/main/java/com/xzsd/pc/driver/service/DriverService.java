package com.xzsd.pc.driver.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.User;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.*;
import com.xzsd.pc.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * @DescriptionDemo 司机服务类
 * @Author zhonghecheng
 * @Date 2020-03-29
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;
    @Resource
    private CustomerDao customerDao;
    /**
     * 新增司机
     * @param driver
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(Driver driver){
        //判断参数是否齐没
        if(null == driver.getDriverName() || driver.getDriverName() == ""){
            return AppResponse.paramError("司机名字为空！");
        }
        if(null == driver.getDriverAcct() || driver.getDriverAcct() == ""){
            return AppResponse.paramError("司机账号为空！");
        }
        if(null == driver.getDriverPhone() || driver.getDriverPhone() == ""){
            return AppResponse.paramError("司机电话为空！");
        }
        if(null == driver.getDriverPass() || driver.getDriverPass() == ""){
            return AppResponse.paramError("司机密码为空！");
        }
        if(null == driver.getDriverIdCard() || driver.getDriverIdCard() == ""){
            return AppResponse.paramError("司机身份证号为空！");
        }
        if(null == driver.getDriverProvincCode() || driver.getDriverProvincCode() == ""){
            return AppResponse.paramError("司机所在省编号为空！");
        }
        if(null == driver.getDriverCityCode() || driver.getDriverCityCode() == ""){
            return AppResponse.paramError("司机所在市编号为空！");
        }
        if(null == driver.getDriverDistinctCode() || driver.getDriverDistinctCode() == ""){
            return AppResponse.paramError("司机所在区为空！");
        }
        //判断是否已经含有司机账号、司机身份证号
        if( driverDao.countDriverAcct(driver.getDriverAcct(),null,null) > 0 ){
            return AppResponse.paramError("司机账号已经存在！");
        }
        //身份证
        if( driverDao.countDriverAcct(null,driver.getDriverIdCard(),null) > 0 ){
            return AppResponse.paramError("司机身份证已经存在！");
        }
        //给司机随机生成编号
        driver.setDriverCode(RandomCode.radmonkey());
        //密码md5加密
        driver.setDriverPass(PasswordUtils.generatePassword(driver.getDriverPass()));
        //如果没有图片地址 ，赋予 默认图片
        if(null == driver.getDriverImage() || driver.getDriverImage() == ""){
            driver.setDriverImage(RandomCode.defaultImageUrl());
        }
        //新增
        int result = driverDao.addDriver(driver);
        //结果
        if(result > 0){
            return AppResponse.success("新增成功！",result);
        }
        return AppResponse.paramError("新增失败！");
    }

    /**
     * 司机信息修改
     * @param updateDriver
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(UpdateDriver updateDriver){
        //判断参数是否齐全
        if(null == updateDriver.getDriverCode() || updateDriver.getDriverCode() == ""){
            return AppResponse.paramError("司机编号不能为空！");
        }
        if(null == updateDriver.getDriverName() || updateDriver.getDriverName() == ""){
            return AppResponse.paramError("司机名字不能为空！");
        }
        if(null == updateDriver.getDriverPhone() || updateDriver.getDriverPhone() == ""){
            return AppResponse.paramError("司机电话不能为空！");
        }
        if(null == updateDriver.getDriverAcct() || updateDriver.getDriverAcct() == ""){
            return AppResponse.paramError("司机账号不能为空！");
        }
        if(null == updateDriver.getDriverPass() || updateDriver.getDriverPass() == ""){
            return AppResponse.paramError("司机密码不能为空！");
        }
        if(null == updateDriver.getDriverIdCard() || updateDriver.getDriverIdCard() == ""){
            return AppResponse.paramError("司机身份证号不能为空！");
        }
        if(null == updateDriver.getDriverProvincCode() || updateDriver.getDriverProvincCode() == ""){
            return AppResponse.paramError("司机省编号不能为空！");
        }
        if(null == updateDriver.getDriverCityCode() || updateDriver.getDriverCityCode() == ""){
            return AppResponse.paramError("司机市区编号不能为空！");
        }
        if(null == updateDriver.getDriverDistinctCode() || updateDriver.getDriverDistinctCode() == ""){
            return AppResponse.paramError("司机区编号不能为空！");
        }
        String msg = "";
        if(null == updateDriver.getVersion() || updateDriver.getVersion() == ""){
            msg = "版本号没有传值或者为0，可能会导致修改失败!";
        }
        //判断是否已经含有司机账号、司机身份证号
        if( driverDao.countDriverAcct(updateDriver.getDriverAcct(),null,updateDriver.getDriverCode()) > 0 ){
            return AppResponse.paramError("司机账号已经存在！");
        }
        //身份证
        if( driverDao.countDriverAcct(null,updateDriver.getDriverIdCard(),updateDriver.getDriverCode()) > 0 ){
            return AppResponse.paramError("司机身份证已经存在！");

        }
        //从数据库获取原加密后的密码，如果跟前台传来的是一样的，那么则不进行加密
        String originPassWord = driverDao.getOriginPassWord(updateDriver.getDriverCode());
        //密码加密
        if(null != updateDriver.getDriverPass() && updateDriver.getDriverPass() !="" && !updateDriver.getDriverPass().equals(originPassWord)){
            updateDriver.setDriverPass(PasswordUtils.generatePassword(updateDriver.getDriverPass()));
        }
        //如果没有图片，那么设置默认
        if(null == updateDriver.getDriverImage() || updateDriver.getDriverImage() == ""){
            updateDriver.setDriverImage(RandomCode.defaultImageUrl());
        }
        //修改
        int result = driverDao.updateDriver(updateDriver);
        //结果
        if(result > 0){
            return AppResponse.success("修改成功！",result);
        }
        return AppResponse.paramError("修改失败！");
    }

    /**
     * 司机信息删除
     * @param updateDriver
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(UpdateDriver updateDriver){
        //判断
        if(null == updateDriver.getDriverCode() || updateDriver.getDriverCode() == ""){
            return AppResponse.paramError("司机编号不能为空！");
        }
        List<String> listCodes = Arrays.asList(updateDriver.getDriverCode().split(","));
        //删除
        int result = driverDao.deleteDriver(listCodes,updateDriver.getUpdateUser());
        //结果
        if(result > 0){
            return AppResponse.success("删除成功！",result);
        }
        return AppResponse.paramError("删除失败！");
    }

    /**
     * 司机信息详情查询
     * @param updateDriver
     * @return
     */
    public AppResponse queryDriverDetail(UpdateDriver updateDriver){
        if(null == updateDriver.getDriverCode() || updateDriver.getDriverCode() == ""){
            return AppResponse.paramError("司机编号不能为空！");
        }
        DriverDetail driverDetail = driverDao.queryDriverDetail(updateDriver.getDriverCode());
        if(null != driverDetail ){
            return AppResponse.success("查询成功！",driverDetail);
        }
        return AppResponse.paramError("查询失败！");
    }

    /**
     * 司机信息列表查询
     * @param driver
     * @return
     */
    public AppResponse queryDriversList(DriverListParamter driver){
        //判断
        if(driver.getPageSize() == 0 || driver.getPageNum() == 0){
            return AppResponse.paramError("页号或者页数量参数不能为空!");
        }
        //获取当前登入用户的编号和角色 ,如果是店长，那么只查找它的店的地址
        String userName = SecurityUtils.getCurrentUserUsername();
        User user = customerDao.queryCurrUser(userName);
        if(null == user){
            return AppResponse.bizError("司机不可以查看这里的模块");
        }
        driver.setCurrUserCode(user.getUserCode());
        driver.setUserRole(user.getUserRole());
        //查找
        PageHelper.startPage(driver.getPageNum(),driver.getPageSize());
        List<DriverListParamter>driverLists = driverDao.dqueryDriverList(driver);
        PageInfo<DriverListParamter>driverListPageInfo = new PageInfo<>(driverLists);
        //结果
        if(driverLists.size()>0){
          return AppResponse.success("查询成功!",driverListPageInfo);
        }
        return AppResponse.paramError("查询为空！");
    }
}
