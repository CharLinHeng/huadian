package com.xzsd.app.storeInvest.service;
import com.xzsd.app.passWord.dao.PassWordDao;
import com.xzsd.app.passWord.entity.PassWord;
import com.xzsd.app.storeInvest.dao.StoreInvestDao;
import com.xzsd.app.storeInvest.entity.InvestCode;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 邀请吗修改服务类
 */
@Service
public class StoreInvestService {
    @Resource
    private StoreInvestDao storeInvestDao;
    public ResponceData updateUserInvest(InvestCode investCode){
        //参数是否齐全
        if(null == investCode.getUserCode() || investCode.getUserCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"用户编号参数缺失",null);
        }
        if(null == investCode.getInvitationCode() || investCode.getInvitationCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"邀请码参数缺失",null);
        }
        //邀请码修改
        int result = storeInvestDao.updateUserInvest(investCode);
        if(result > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"门店邀请码绑定成功!",null);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"门店邀请码绑定失败!",null);
    }
}
