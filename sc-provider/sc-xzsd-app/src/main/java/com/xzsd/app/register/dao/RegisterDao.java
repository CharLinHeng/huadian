package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.Register;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao{

    /**
     * 用户注册
     * @param register
     * @return
     */
    public int addRegister(Register register);



}
