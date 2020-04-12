package com.xzsd.app.register.service;

import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.Register;
import com.xzsd.app.util.RandomCode;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterService {
    private ResponceData responceData;
    @Resource
    RegisterDao registerDao;
    /**
     * 注册新增用户 app 端
     * @param register
     * @return
     */
    public ResponceData register(Register register){
        //判断参数是否齐全
        if(null == register.getUserAcc() || register.getUserAcc() == ""){
            return  new ResponceData(ResponceDataState.values()[0].getCode(),"用户账号不能为空!",null);
        }
        if(null == register.getUserPass() || register.getUserPass() == ""){
            return  new ResponceData(ResponceDataState.values()[0].getCode(),"用户密码不能为空!",null);
        }
        if(null == register.getUserPhone() || register.getUserPhone() == ""){
            return  new ResponceData(ResponceDataState.values()[0].getCode(),"用户手机号不能为空!",null);
        }
        if(null == register.getUserIdCard() || register.getUserIdCard() == ""){
            return  new ResponceData(ResponceDataState.values()[0].getCode(),"用户身份证不能为空!",null);
        }
        if(null == register.getUserEmail()){
            register.setUserEmail("");
        }
        if(null == register.getUserName()){
            register.setUserName("");
        }
        //默认用户性别为女
        if(null == register.getUserSex() || register.getUserSex() == ""){
            register.setUserSex("0");
        }
        //随机生成userCode
        register.setUserCode(RandomCode.radmonkey());
        //判断是否已经存在账号名
        if(registerDao.countActOrPhone(register.getUserAcc(),null) > 0){
            return  new ResponceData(ResponceDataState.values()[3].getCode(),"用户账号已存在!",null);
        }
        //判断手机号是否已经注册
        if(registerDao.countActOrPhone(null,register.getUserPhone()) > 0){
            return  new ResponceData(ResponceDataState.values()[3].getCode(),"用户手机已存在!",null);
        }
        int result = registerDao.addRegister(register);
        if(result > 0){
            return  new ResponceData(ResponceDataState.values()[0].getCode(),"注册成功!",null);
        }
        return  new ResponceData(ResponceDataState.values()[3].getCode(),"注册失败",null);
    }
}
