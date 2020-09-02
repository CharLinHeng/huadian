package com.xzsd.app.address.dao;

import com.xzsd.app.address.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    /**
     * 增加地址
     * @param address
     * @return
     */
    int addAddress (Address address);

    /**
     * 删除地址
     * @param addressCode
     * @param userCode
     * @return
     */
    int deleteAddress(@Param("addressCode")List<String> addressCode,@Param("userCode") String userCode);

    /**
     * 修改地址
     * @param address
     * @return
     */
    int updateAddress(Address address);

    /**
     * 地址列表
     * @param address
     * @return
     */
    List<Address> addressList(Address address);

    /**
     * 获取单个地址
     * @param addressCode
     * @return
     */
    Address getAddress(String addressCode);


}
