package com.xzsd.app.passWord.dao;
import com.xzsd.app.passWord.entity.PassWord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PassWordDao {
    /**
     * 修改密码-用户表
     * @param passWord
     * @return
     */
    int getCinPass(PassWord passWord);

    /**
     * 修改密码-司机表
     * @param passWord
     * @return
     */
    int getCinPassDriver(PassWord passWord);
}
