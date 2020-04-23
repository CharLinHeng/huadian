package com.xzsd.pc.user.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.user.entity.User;
import com.xzsd.pc.user.services.RedisService;
import com.xzsd.pc.user.services.UserServices;
import com.xzsd.pc.util.RandomCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/**
 * @Description 用户增删改查
 * @Author zhonghecheng
 * @Date 2020-03-24
 */
@RestController
@RequestMapping("/user")
public class HandleUserController {
    @Resource
    private UserServices userServices;
    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisTemplate redisTemplate;
    @ResponseBody
    @PostMapping("addUser")
    /**
     * 新增用户
     * 2020年3月24日19:20:20
     */
    public AppResponse addUser(User user){
        //先随机获取用户编号
        String user_code = RandomCode.radmonkey();
        user.setUserCode(user_code);
        //获取当前创建的用户
        user.setCreateUser(SecurityUtils.getCurrentUserUsername());
        AppResponse AppResponse = userServices.addUser(user);
        return AppResponse;
    }
    /**
     * 查询用户
     * @return
     */
    @PostMapping("queryUser")
    public AppResponse queryUser(User user){

        try {
            AppResponse AppResponse = userServices.queryUser(user);
            return AppResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 随机用户编号测试
     * @return
     */
    @PostMapping("testCode")
    public String testCode(){
        return RandomCode.radmonkey();
    }

    /**
     * 用户修改
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(User user){

        try {
            user.setUpdateUser(SecurityUtils.getCurrentUserUsername());
            AppResponse AppResponse = userServices.updateUser(user);
            return AppResponse;
        } catch (Exception e) {

            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  删除用户
     * @param user
     * @return AppResponse
     * @author zhc
     * @Date 2020年3月25日09:35:04
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(User user){
        try {
            user.setUpdateUser(SecurityUtils.getCurrentUserUsername());
            AppResponse AppResponse = userServices.deleteUser(user);
            return AppResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     *  查询用户列表
     * @return AppResponse
     * @author zhc
     * @Date 2020年3月25日09:35:04
     */
    @PostMapping("queryUserList")
    public AppResponse queryUserList(User user){

        try {
            AppResponse AppResponse = userServices.queryUserList(user);
            return AppResponse;
        } catch (Exception e) {
            return AppResponse.bizError("后台有可能出错了，可能是sql语句出错也可能是NullPointException!"+e.getMessage());
        }
    }
    @PostMapping("getuserdata")
    public AppResponse getuserdata(User user){
        try {
            AppResponse AppResponse = userServices.getuserdata();
            return AppResponse;
        } catch (Exception e) {
            return AppResponse.bizError("后台有可能出错了，可能是sql语句出错也可能是NullPointException!"+e.getMessage());
        }
    }
}
