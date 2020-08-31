package com.xzsd.pc.customer.controller;
import com.neusoft.core.restful.AppResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.customer.entity.Customer;
import com.xzsd.pc.customer.service.CustomerService;
import javax.annotation.Resource;
/**
 * 顾客列表查询
 */
@RestController
@RequestMapping("/customerQuery")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @PostMapping("queryCustomer")
    public AppResponse queryCustomer(Customer customer){
        try{
            return customerService.queryCustomer(customer);
        }catch (Exception e){
            throw e;
        }
    }

}
