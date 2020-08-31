package com.xzsd.app.passWord.dao;
import com.xzsd.app.passWord.entity.PassWord;
import com.xzsd.app.passWord.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PassWordDao {
    /**
     * 查询原来的密码
     * @param passWord
     * @return
     */
    PassWord getOrignPass(PassWord passWord);

    /**
     * 更新密码
     * @param passWord
     * @return
     */
    int updatePassWord(PassWord passWord);
    /**
     * 查询当前用户的角色
     * @return
     */
    User queryCurrUser(@Param("userCode")String userCode);

    /**
     * 查询司机信息
     * @param userCode
     * @return
     */
    User queryCurrDriver(@Param("userCode")String userCode);
}
