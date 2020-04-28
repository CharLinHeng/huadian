package com.xzsd.pc.user.services;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.user.entity.AdminData;
import com.xzsd.pc.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.User;
import javax.annotation.Resource;
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
    /**
     * 查询用户
     * @param
     * @return
     * @Author zhc
     * @Date 2020-03-24
     */
    public AppResponse queryUser(User user){
        User appResponse = userDao.queryUserData(user);
        if(null == appResponse){
            return AppResponse.bizError("查询为空");
        }
        return AppResponse.success("查询成功!",appResponse);
    }
    /**
     * 增加用户
     * author: zhc
     * 2020年3月24日19:05:18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(User user){
            //判断参数
            if(null == user.getUserEmail()){
                user.setUserEmail("");
//                AppResponse.success,"用户邮箱参数为空!",null);
            }
            if(null == user.getUserPass()){
                return AppResponse.paramError("用户密码参数为空!");
            }
            if(null == user.getUserName()){
                return AppResponse.paramError("用户名称为空!");
            }
            if(null == user.getUserAccount()){
                return AppResponse.paramError("用户账号为空!");
            }
            if(null == user.getUserPhone()){
               return AppResponse.paramError("用户手机号为空!");
            }
            //先查询 是否存在账号、手机
            if(userDao.countUserAcct(user)>0){
                return AppResponse.paramError("用户账号已存在!");
            }
            if(userDao.countUserPhone(user)>0){
                return AppResponse.paramError("用户手机号已存在!");
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
                AppResponse.bizError("增加失败");
            }
            return AppResponse.success("增加成功");
    }

    /**
     * 更新用户
     * author: zhc
     * 2020年3月24日22:52:47
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(User user){
        if(null == user.getUserCode()){
            return AppResponse.paramError("用户编号为空!");
        }
        //更新用户
        if(userDao.countUserAcct(user) > 0){
            return AppResponse.paramError("用户账号已存在!");
        }
        //设置默认头像
        if(null == user.getDefaultImageUrl() || user.getDefaultImageUrl() ==""){
            user.setDefaultImageUrl(RandomCode.defaultImageUrl());
        }
        //先比较原来的密码，如果不相同，加密新密码
        String originPassWord = userDao.getOriginPassWord(user.getUserCode());
        if(null != user.getUserPass() && user.getUserPass() != "" && !originPassWord.equals(user.getUserPass())){
            user.setUserPass(PasswordUtils.generatePassword(user.getUserPass()));
        }
        int result = userDao.updateUser(user);
        if(0 == result){
            return  AppResponse.bizError("更新失败");
        }
        return AppResponse.success("更新成功");
    }
    /**
     * 删除用户
     * author: zhc
     * 2020年3月25日09:16:14
     */
    @Transactional(rollbackFor = Exception.class)
     public AppResponse deleteUser(User user){
         //如果有逗号，那么是分割开来
        if(null == user.getUserCode()){
           return AppResponse.paramError("用户编号为空!");
        }
         List<String> listCode = Arrays.asList(user.getUserCode().split(","));
         if(listCode.size()  == 0){
            return AppResponse.paramError("删除的数量为空");
         }
         int result =  userDao.deleteUser(listCode,user.getUserCode());
         if(result > 0){
             return AppResponse.success("删除成功!");
         }
         return AppResponse.bizError("删除失败");
     }
    /**
     * 用户列表查询
     *  联合 用户表 和 司机表 进行查询 因为我是分开来写的
     * author: zhc
     * 2020年3月25日10:56:26
     */
    public AppResponse queryUserList(User user){
        //分页
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        List<User> userInfoList = userDao.listUsers(user);
        PageInfo<User> pageData = new PageInfo<User>(userInfoList);
        if(userInfoList.size() == 0){
            return AppResponse.bizError("查询为空");
        }
        return AppResponse.success("查询成功",pageData);
    }

    /**
     * 获取当前登入用户信息
     * @return
     */
    public AppResponse getuserdata(){
        String userCode = SecurityUtils.getCurrentUserUsername();
        if(userCode.length() == 0){
            return AppResponse.bizError("当前没有登入用户!");
        }
        AdminData adminData = userDao.getuserdata(userCode);
        if(null != adminData){
            return AppResponse.success("获取成功!",adminData);
        }
        return AppResponse.bizError("获取失败，请重新登入!");
    }
}
