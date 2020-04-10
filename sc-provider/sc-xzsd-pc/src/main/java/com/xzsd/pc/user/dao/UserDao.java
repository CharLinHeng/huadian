package com.xzsd.pc.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xzsd.pc.user.entity.User;

import java.util.List;

/**
 * @ClassName userDao
 * @Description Demo
 * @Author zhc
 * @Date 2020-03-24
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param user 用户信息
     * @return
     */
    int countUserAcct(User user);
    /**
     * 统计用户手机号数量
     * @param user 用户信息
     * @return
     */
    int countUserPhone(User user);

    /**
     * 获取用户数据
     * @return
     */
    User queryUserData(User user);
    /**
     * 添加用户
     *
     */
    int addUser(User user);

    /**
     * 更新用户
     * @param user
     * 2020年3月24日 20:20:35
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * 2020年3月24日 20:40:35
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("updateUser") String user_code);

    /**
     *
     * 查询用户列表
     * @param user
     * @return
     */
    List<User> listUsersByPage(User user);
}
