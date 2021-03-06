package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.Register;
import com.xzsd.app.register.entity.UserInfo;
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

    /**
     * 用户  店长 信息获取
     * @param userCode
     * @return
     */
    UserInfo getUserInfo(@Param("userCode")String userCode);

    /**
     * 司机信息获取
     * @param userCode
     * @return
     */
    UserInfo getDriverInfo(@Param("userCode")String userCode);

    /**
     * 查询门店店长的门店编号
     * @param userCode
     * @return
     */
    String getStoreCode(@Param("userCode")String userCode);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);
}
