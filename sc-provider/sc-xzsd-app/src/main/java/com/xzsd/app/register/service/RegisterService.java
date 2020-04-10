package com.xzsd.app.register.service;

import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.Register;
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





        return  new ResponceData(ResponceDataState.values()[4].getCode(),"注册失败",null);
    }
}
