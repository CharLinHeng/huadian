package com.xzsd.app.address.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.address.dao.AddressDao;
import com.xzsd.app.address.entity.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class AddressServices {

    @Resource
    private AddressDao addressDao;

    /**
     * 增加地址
     * @param address
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addAddress(Address address){
        address.setAddressCode(StringUtil.getCommonCode(2));
        int count = addressDao.addAddress(address);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 删除地址
     * @param address
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteAddress(Address address){
        List<String> addressCode = Arrays.asList(address.getAddressCode().split(","));
        int count = addressDao.deleteAddress(addressCode,address.getUpdateUser());
        AppResponse appResponse = AppResponse.success("删除成功！");
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改地址
     * @param address
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateAddress(Address address){
        int count = addressDao.updateAddress(address);
        if (count == 0) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 地址列表
     * @param address
     * @return
     */
    public AppResponse addressList(Address address){
        PageHelper.startPage(address.getPageNum(), address.getPageSize());
        List<Address> goodsInfoList = addressDao.addressList(address);
        // 包装Page对象
        PageInfo<Address> pageData = new PageInfo<Address>(goodsInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 收获地址详情
     * @param addressCode
     * @return
     */
    public AppResponse getAddress(String addressCode){
        Address address = addressDao.getAddress(addressCode);
        if (address == null){
            return AppResponse.notFound("未找到数据");
        }
        return AppResponse.success("查询收货地址详情", address);
    }

}
