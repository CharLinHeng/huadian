package com.xzsd.app.register.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.Register;
import com.xzsd.app.register.entity.UserInfo;
import com.xzsd.app.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * @Auther: zhonghecheng
 * @Date: 2020年4月11日13:45:58
 * @Description: app注册
 */
@Service
public class RegisterService {
    @Resource
    RegisterDao registerDao;
    private static final int DRIVERROLE = 2;
    /**
     * 注册新增用户 app 端
     * @param register
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse register(Register register){
        //判断参数是否齐全
        if(null == register.getUserAcc() || register.getUserAcc() == ""){
            return AppResponse.paramError("用户账号不能为空!");
        }
        if(null == register.getUserPhone() || register.getUserPhone() == "") {
            return AppResponse.paramError("用户手机号不能为空!");
        }
        //判断是否已经存在账号名
        if(registerDao.countActOrPhone(register.getUserAcc(),null) > 0){
            return  AppResponse.paramError("用户账号已存在!");
        }
        //判断手机号是否已经注册
        if(registerDao.countActOrPhone(null,register.getUserPhone()) > 0){
            return  AppResponse.paramError("用户手机已存在!");
        }
        //随机生成userCode
        register.setUserCode(RandomCode.radmonkey());
        //密码加密
        register.setUserPass(PasswordUtils.generatePassword(register.getUserPass()));
        //赋予 默认image地址
        register.setImagrUrl(RandomCode.getDefaultImageUrl());
        //新增用户
        int result = registerDao.addRegister(register);
        if(result > 0){
            return AppResponse.success("注册成功!");
        }
        return AppResponse.bizError("注册失败");
    }
    /**
     * 获取当前登入的信息的接口
     * @return
     */
    public AppResponse getuserdata(){
        //获取当前 账号 编号
        String userCode = SecurityUtils.getCurrentUserId();
        UserInfo userInfo = registerDao.getUserInfo(userCode);
        if(null == userInfo){
            //说明是司机，
            userInfo = registerDao.getDriverInfo(userCode);
            if(null != userInfo){
                userInfo.setUserRole(DRIVERROLE);
                return AppResponse.success("获取司机信息成功!",userInfo);
            }
        }else{
            //设置店长的门店编号
            String storeCode = registerDao.getStoreCode(userInfo.getUserCode());
            if(null != storeCode){
                userInfo.setStoreCode(storeCode);
            }
            return AppResponse.success("获取信息成功!",userInfo) ;
        }
        return AppResponse.bizError("获取失败");
    }
    /**
     * 修改用户信息
     * @return
     */
    public AppResponse udateUserData(UserInfo userInfo){
        userInfo.setUserCode(SecurityUtils.getCurrentUserId());
        int result = registerDao.updateUserInfo(userInfo);
        if(result > 0){
            return AppResponse.success("修改成功!");
        }
        return AppResponse.bizError("修改失败!");
    }
}
