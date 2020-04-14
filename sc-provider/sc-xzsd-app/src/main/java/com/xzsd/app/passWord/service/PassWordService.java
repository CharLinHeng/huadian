package com.xzsd.app.passWord.service;
import com.xzsd.app.passWord.dao.PassWordDao;
import com.xzsd.app.passWord.entity.PassWord;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.RandomCode;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 修改服务类
 */
@Service
public class PassWordService {
    @Resource
    private PassWordDao passWordDao;
    public ResponceData updateUserPassword(PassWord passWord){
        //参数是否齐全
        if(null == passWord.getUserCode() || passWord.getUserCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"用户编号参数缺失",null);
        }
        if(null == passWord.getUserPass() || passWord.getUserPass() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"原密码参数缺失",null);
        }
        if(null == passWord.getCinPass() || passWord.getCinPass() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"新密码参数缺失",null);
        }
        //密码加密
        passWord.setCinPass(PasswordUtils.generatePassword(passWord.getCinPass()));
        passWord.setUserPass(PasswordUtils.generatePassword(passWord.getUserPass()));
        //用户密码修改
        int result = passWordDao.getCinPass(passWord);
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"修改用户角色密码成功！",null);
        }else{
            //司机密码修改
            result = passWordDao.getCinPassDriver(passWord);
            if(result > 0){
                return new ResponceData(ResponceDataState.values()[0].getCode(),"修改司机角色密码成功！",null);
            }
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"用户不存在或者原密码错误！",null);
    }
}
