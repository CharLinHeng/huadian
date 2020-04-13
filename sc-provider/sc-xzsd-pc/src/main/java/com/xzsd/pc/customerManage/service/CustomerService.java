package com.xzsd.pc.customerManage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.customerManage.entity.User;
import org.springframework.stereotype.Service;
import com.xzsd.pc.customerManage.dao.CustomerDao;
import com.xzsd.pc.customerManage.entity.Customer;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {
    private ResponceData responceData;
    @Resource
    private CustomerDao customerDao;

    /**
     * 客户列表查询
     * @param customer
     * @return
     */
    public ResponceData queryCustomer(Customer customer){
        //获取当前用户编号
        if(null == customer.getUserCode() || customer.getUserCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"用户编号不能为空!",null);
        }
        if(customer.getPageNum() == 0 || customer.getPageSize() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"页号或者页数量不能为空!",null);
        }
        //查询用户角色
        customer.setUserRole(customerDao.queryCurrUser(customer.getUserCode()).getUserRole());
        //分页查询
        PageHelper.startPage(customer.getPageNum(),customer.getPageSize());
        List<Customer> customerList= customerDao.queryCustomer(customer);
        PageInfo<Customer>customerPageInfo = new PageInfo<>(customerList);
        if(customerList.size() > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",customerPageInfo);
        }else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
        }
    }
}
