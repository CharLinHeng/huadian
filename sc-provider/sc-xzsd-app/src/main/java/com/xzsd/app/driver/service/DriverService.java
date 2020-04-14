package com.xzsd.app.driver.service;

import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.Driver;
import com.xzsd.app.driver.entity.Store;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 司机信息服务实现类
 * 2020年4月13日18:56:26
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 司机列表查询
     * @param driver
     * @return
     */
    public ResponceData queryDriverList(Driver driver){
        //判断
        if(null == driver.getStoreCode() || driver.getStoreCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店编号参数缺失",null);
        }
        List<Driver> driverList = driverDao.queryDriverList(driver.getStoreCode());
        if(driverList.size() > 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询成功!",driverList);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }

    /**
     * 门店信息详情查询
     * @param store
     * @return
     */
    public ResponceData queryStoreDetail(Store store){
        if(null == store.getStoreCode() || store.getStoreCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"门店编号为空!",null);
        }
        Store store1 = driverDao.queryStoreDetail(store.getStoreCode());
        if(null != store1){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询成功!",store1);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }
}
