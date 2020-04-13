package com.xzsd.pc.customer.dao;


import com.xzsd.pc.customer.entity.User;
import org.apache.ibatis.annotations.Mapper;
import com.xzsd.pc.customer.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerDao {
    /**
     * 客户列表查询
     * @param customer
     * @return
     */
    List<Customer> queryCustomer(Customer customer);

    /**
     * 查询当前用户的角色
     * @return
     */
    User queryCurrUser(@Param("userCode")String userCode);
}
