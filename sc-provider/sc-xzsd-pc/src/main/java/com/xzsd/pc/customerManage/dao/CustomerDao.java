package com.xzsd.pc.customerManage.dao;


import org.apache.ibatis.annotations.Mapper;
import com.xzsd.pc.customerManage.entity.Customer;

import java.util.List;

@Mapper
public interface CustomerDao {


    /**
     * 客户列表查询
     * @param customer
     * @return
     */
    List<Customer> queryCustomer(Customer customer);
}
