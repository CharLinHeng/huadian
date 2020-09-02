package com.xzsd.app.address.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.address.entity.Address;
import com.xzsd.app.address.service.AddressServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/address")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
    @Resource
    private AddressServices addressServices;

    /**
     *增加地址
     * @param address
     * @return
     */
    @RequestMapping("addAddress")
    public AppResponse addAddress(Address address){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            address.setUpdateUser(userId);
            address.setUserCode(userId);
            AppResponse appResponse = addressServices.addAddress(address);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增收货地址失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除地址
     * @param address
     * @return
     */
    @RequestMapping("deleteAddress")
    public AppResponse deleteAddress(Address address){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            address.setUpdateUser(userId);
            return addressServices.deleteAddress(address);
        } catch (Exception e) {
            logger.error("删除门店信息失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改地址
     * @param address
     * @return
     */
    @RequestMapping("updateAddress")
    public AppResponse updateAddress(Address address){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            address.setUpdateUser(userId);
            return addressServices.updateAddress(address);
        } catch (Exception e) {
            logger.error("修改收获地址失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *地址列表
     * @param address
     * @return
     */
    @RequestMapping("addressList")
    public AppResponse addressList(Address address){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            address.setUserCode(userId);
            return addressServices.addressList(address);
        } catch (Exception e) {
            logger.error("查询地址列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 收获地址详情
     * @param addressCode
     * @return
     */
    @RequestMapping("getAddress")
    public AppResponse getAddress(String addressCode){
        try {
            return addressServices.getAddress(addressCode);
        } catch (Exception e) {
            logger.error("查询门店信息详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
