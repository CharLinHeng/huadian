package com.xzsd.pc.user.services;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.RandomCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.User;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @DescriptionDemo 用户管理Service
 * @Author zhc
 * @Date 2020-03-24
 */
@Service
public class UserServices {
    @Resource
    private UserDao userDao;
    private ResponceData responceData;
    /**
     * 查询用户
     * @param
     * @return
     * @Author zhc
     * @Date 2020-03-24
     */
    public ResponceData queryUser(User user){
        User appResponse = userDao.queryUserData(user);
        if(null == appResponse){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空",null);
        }
        return  new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功",appResponse);
    }
    /**
     * 增加用户
     * author: zhc
     * 2020年3月24日19:05:18
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addUser(User user){
            //判断参数
            if(null == user.getUserEmail()){
                return new ResponceData(ResponceDataState.values()[3].getCode(),"用户邮箱参数为空!",null);
            }
            if(null == user.getUserPass()){
                return new ResponceData(ResponceDataState.values()[3].getCode(),"用户密码参数为空!",null);
            }
            if(null == user.getUserName()){
                return new ResponceData(ResponceDataState.values()[3].getCode(),"用户名称为空!",null);
            }
            if(null == user.getUserAccount()){
                return new ResponceData(ResponceDataState.values()[3].getCode(),"用户账号为空!",null);
            }
            if(null == user.getUserPhone()){
               return new ResponceData(ResponceDataState.values()[3].getCode(),"用户手机号为空!",null);
            }
            //先查询 是否存在账号、手机
            if(userDao.countUserAcct(user)>0){
                return new ResponceData(ResponceDataState.values()[3].getCode(),"用户账号已存在!",null);
            }
            if(userDao.countUserPhone(user)>0){
                return new ResponceData(ResponceDataState.values()[3].getCode(),"用户手机号已存在!",null);
            }
            //设置默认头像
            if(null == user.getDefaultImageUrl() || user.getDefaultImageUrl() ==""){
                user.setDefaultImageUrl(RandomCode.defaultImageUrl());
            }
            //密码加密
            user.setUserPass(PasswordUtils.generatePassword(user.getUserPass()));
            int result = userDao.addUser(user);
            //如果新增成功，返回结果
            if(result == 0){
                return new ResponceData(ResponceDataState.values()[3].getCode(),"增加失败",null);
            }
            return new ResponceData(ResponceDataState.values()[0].getCode(),"增加成功",null);
    }

    /**
     * 更新用户
     * author: zhc
     * 2020年3月24日22:52:47
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateUser(User user){
        if(null == user.getUserCode()){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"用户编号为空!",null);
        }
        int result = userDao.updateUser(user);
        if(0 == result){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"更新失败",null);
        }
        return new ResponceData(ResponceDataState.values()[0].getCode(),"更新成功",null);
    }
    /**
     * 删除用户
     * author: zhc
     * 2020年3月25日09:16:14
     */
    @Transactional(rollbackFor = Exception.class)
     public ResponceData deleteUser(User user){
         //如果有逗号，那么是分割开来
         List<String> listCode = Arrays.asList(user.getUserCode().split(","));
         int result =  userDao.deleteUser(listCode,user.getUserCode());
         if(result > 0){
             responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功",null);
         }
         return new ResponceData(ResponceDataState.values()[3].getCode(),"删除失败",null);
     }
    /**
     * 用户列表查询
     * author: zhc
     * 2020年3月25日10:56:26
     */
    public ResponceData queryUserList(User user){
        //逻辑判断
        if(user.getPageNum() == 0 || user.getPageSize() == 0){
            return  new ResponceData(ResponceDataState.values()[3].getCode(),"页号或者页数量参数不能为空",null);
        }
        //分页
        PageHelper.startPage(user.getPageSize(),user.getPageNum());
        List<User> userInfoList = userDao.listUsersByPage(user);
        PageInfo<User> pageData = new PageInfo<User>(userInfoList);
        if(userInfoList.size() == 0){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空",userInfoList);
        }
        return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功",pageData);
    }
}
