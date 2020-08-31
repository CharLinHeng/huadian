package com.xzsd.app.register.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.register.entity.Register;
import com.xzsd.app.register.entity.UserInfo;
import com.xzsd.app.register.service.RegisterService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 注册新增类Controller
 * zhc
 * 2020年4月15日14:37:51
 */
@RestController
@RequestMapping("/customer")
public class RegisterController {
    @Resource
    private RegisterService registerService;
    /**
     * 注册-新增用户
     * @param register
     * @return
     */
    @ResponseBody
    @PostMapping("register")
    public AppResponse register(Register register){
        try{
            return registerService.register(register);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 信息获取
     * @return
     */
    @PostMapping("getuserdata")
    public AppResponse getuserdata(){
        try{
            return registerService.getuserdata();
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @PostMapping("udateUserData")
    public AppResponse udateUserData(UserInfo userInfo){
        try{
            return registerService.udateUserData(userInfo);
        }catch (Exception e){
            throw e;
        }
    }
}
