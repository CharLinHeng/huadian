package com.xzsd.app.register.service;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.Register;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.RandomCode;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * app注册
 * zhc
 * 2020年4月15日14:28:20
 */
@Service
public class RegisterService {
    @Resource
    RegisterDao registerDao;
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
        //新增用户
        int result = registerDao.addRegister(register);
        if(result > 0){
            return AppResponse.success("注册成功!");
        }
        return AppResponse.bizError("注册失败");
    }
}
