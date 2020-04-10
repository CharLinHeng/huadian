package com.xzsd.app.register.controller;
import com.xzsd.app.register.entity.Register;
import com.xzsd.app.register.service.RegisterService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 注册新增类
 */
@RestController
@RequestMapping("/customer")
public class RegisterController {
//    private ResponceData responceData;
    @Resource
    private RegisterService registerService;

    /**
     * 注册-新增用户
     * @param register
     * @return
     */
    @ResponseBody
    @PostMapping("register")
    public ResponceData register(Register register){
        try{
            return registerService.register(register);
        }catch (Exception e){
            throw e;
        }
    }


}
