package com.xzsd.pc.user.controller;


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
import com.xzsd.pc.util.ResponceData;

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
    public ResponceData addUser(User user){

        //先随机获取用户编号
        String user_code = RandomCode.radmonkey();
        user.setUserCode(user_code);

        ResponceData responceData = userServices.addUser(user);
        return responceData;
    }
    /**
     * 查询用户
     * @return
     */
    @PostMapping("queryUser")
    public ResponceData queryUser(User user){

        try {
            ResponceData responceData = userServices.queryUser(user);

            return responceData;
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
    public ResponceData updateUser(User user){

        try {
            ResponceData responceData = userServices.updateUser(user);

            return responceData;
        } catch (Exception e) {

            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  删除用户
     * @param user
     * @return responceData
     * @author zhc
     * @Date 2020年3月25日09:35:04
     */
    @PostMapping("deleteUser")
    public ResponceData deleteUser(User user){

        try {
            ResponceData responceData = userServices.deleteUser(user);
            return responceData;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     *  查询用户列表
     * @return responceData
     * @author zhc
     * @Date 2020年3月25日09:35:04
     */
    @PostMapping("queryUserList")
    public ResponceData queryUserList(User user){

        try {
            ResponceData responceData = userServices.queryUserList(user);
            return responceData;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

}
