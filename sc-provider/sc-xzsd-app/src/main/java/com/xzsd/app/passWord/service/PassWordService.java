package com.xzsd.app.passWord.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.passWord.dao.PassWordDao;
import com.xzsd.app.passWord.entity.PassWord;
import com.xzsd.app.passWord.entity.User;
import com.xzsd.app.util.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Auther: zhonghecheng
 * @Date: 2020年4月11日13:45:58
 * @Description: 修改密码服务类
 */
@Service
public class PassWordService {
    @Resource
    private PassWordDao passWordDao;
    private final static int DRIVERROLE = 2;
    /**
     * 修改密码
     * @param passWord
     * @return
     */
    public AppResponse updateUserPassword(PassWord passWord){
        //参数是否齐全
        if(null == passWord.getUserPass() || passWord.getUserPass() == ""){
            return AppResponse.paramError("原密码参数缺失");
        }
        if(null == passWord.getCinPass() || passWord.getCinPass() == ""){
            return AppResponse.paramError("新密码参数缺失");
        }
        //获取当前登入人的编号
        passWord.setUserCode(SecurityUtils.getCurrentUserId());
        //根据编号，获取当前登入用户的  角色
        User user = passWordDao.queryCurrUser(passWord.getUserCode());
        //如果没获取到，那么去司机表中找
        if(null == user){
            user = passWordDao.queryCurrDriver(passWord.getUserCode());
            user.setUserRole(DRIVERROLE);
        }
        //设置角色
        passWord.setUserRole(user.getUserRole());
        //新密码加密
        passWord.setCinPass(PasswordUtils.generatePassword(passWord.getCinPass()));
        //店长 用户 司机 原来密码查询
        PassWord passWordOrigin = passWordDao.getOrignPass(passWord);
        //比较原密码
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //判断结果的值
        int result = 0;
        if(passWord.getUserRole() == DRIVERROLE){
            //说明是司机
            if(bCryptPasswordEncoder.matches(passWord.getUserPass(),passWordOrigin.getDriverTablePass())){
                //密码匹配正确，进行更新
                result = passWordDao.updatePassWord(passWord);
                if(result > 0){
                    return AppResponse.success("更新成功!");
                }
            }
            return AppResponse.paramError("原密码输入不正确!");
        }
        //否则是店长和用户
        if(bCryptPasswordEncoder.matches(passWord.getUserPass(),passWordOrigin.getUserTablePass())){
            //密码匹配正确，进行更新
            result = passWordDao.updatePassWord(passWord);
            if(result > 0){
               return AppResponse.success("更新成功!");
            }
        }
        return AppResponse.paramError("原密码输入不正确!");
    }
}
