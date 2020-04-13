package com.xzsd.pc.customer.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.customer.entity.Customer;
import com.xzsd.pc.customer.service.CustomerService;
import com.xzsd.pc.util.ResponceData;

import javax.annotation.Resource;

/**
 * 顾客列表查询
 */
@RestController
@RequestMapping("/customerQuery")
public class CustomerController {
    private ResponceData responceData;
    @Resource
    private CustomerService customerService;

    @PostMapping("queryCustomer")
    public ResponceData queryCustomer(Customer customer){
        try{
            responceData = customerService.queryCustomer(customer);
            return responceData;
        }catch (Exception e){
            throw e;
        }
    }

}
