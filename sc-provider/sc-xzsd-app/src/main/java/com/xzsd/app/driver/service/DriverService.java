package com.xzsd.app.driver.service;

import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.*;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 司机信息服务实现类
 * 2020年4月13日18:56:26
 */
@Service
public class DriverService {
    private static final int POIOR = 0;
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
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",driverList);
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
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",store1);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }

    /**
     * 司机信息详情查询
     * @param driverVO
     * @return
     */
    public ResponceData queryDriverInformationDetail(DriverVO driverVO){
        if(null == driverVO.getDriverCode() || driverVO.getDriverCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机编号为空!",null);
        }
        DriverVO driverVOOut = driverDao.queryDriverInformationDetail(driverVO.getDriverCode());
        if(null != driverVOOut){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",driverVOOut);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }

    /**
     * 司机负责门店信息查询
     * @param driverResponsibleArea
     * @return
     */
    public ResponceData queryDriverInformationDetail(DriverResponsibleArea driverResponsibleArea){
        //判断司机编号参数
        if(null == driverResponsibleArea.getDriverCode() || driverResponsibleArea.getDriverCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"司机编号为空!",null);
        }
        //查询初步信息 -此时还没有查询到 省市区名称，查的是  省市区编号
        List<DriverResponsibleArea> driverResponsibleAreas = driverDao.queryDriverResponsibleList(driverResponsibleArea.getDriverCode());
        //将省市区编号和详细地址整合  下面这个查询就是将  以省市区编号为参数， 返回省市区名称 ,因为地址都是一样的，所以 默认第一个
        AreaName areaNameList = driverDao.queryPCD(driverResponsibleAreas.get(POIOR));
        List<DriverResponsibleAreaOut>driverResponsibleAreaOuts = new ArrayList<>();
        for(int i = 0;i < driverResponsibleAreas.size();i++){
            //省市区 名称 拼接
            String area = areaNameList.getProvinceName()+areaNameList.getCityName()+areaNameList.getDistinctName()+
                    driverResponsibleAreas.get(i).getDetailAddress();
            DriverResponsibleAreaOut driverResponsibleAreaOut = new DriverResponsibleAreaOut();
            //负责的门店地址
            driverResponsibleAreaOut.setStoreAddress(area);
            //门店名称
            driverResponsibleAreaOut.setStoreName(driverResponsibleAreas.get(i).getStoreName());
            //设置店长姓名
            driverResponsibleAreaOut.setUserName(driverResponsibleAreas.get(i).getUserName());
            //门店手机号
            driverResponsibleAreaOut.setUserPhone(driverResponsibleAreas.get(i).getUserPhone());
            //添加到输出队列
            driverResponsibleAreaOuts.add(driverResponsibleAreaOut);
        }
        if(driverResponsibleAreaOuts.size() > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",driverResponsibleAreaOuts);
        }
        //判断结果
        return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
    }

}
