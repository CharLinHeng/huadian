package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegisterDao{

    /**
     * 用户注册
     * @param register
     * @return
     */
     int addRegister(Register register);

    /**
     * 判断是否重复
     * @param acct
     * @param phone
     * @return
     */
    int countActOrPhone(@Param("userAcc")String acct,@Param("userPhone")String phone);


}
