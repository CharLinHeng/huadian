package com.xzsd.app.storeInvest.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.passWord.dao.PassWordDao;
import com.xzsd.app.passWord.entity.PassWord;
import com.xzsd.app.storeInvest.dao.StoreInvestDao;
import com.xzsd.app.storeInvest.entity.BindStore;
import com.xzsd.app.storeInvest.entity.InvestCode;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.RandomCode;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * 邀请码绑定门店修改或新增 服务类
 */
@Service
public class StoreInvestService {
    @Resource
    private StoreInvestDao storeInvestDao;

    /**
     * 门店邀请码绑定
     * @param investCode
     * @return
     */
    public AppResponse updateUserInvest(InvestCode investCode){
        //参数是否齐全
        if(null == investCode.getInvitationCode() || investCode.getInvitationCode() == ""){
            return AppResponse.paramError("邀请码参数缺失");
        }
        //获取当前登入用户编号
        investCode.setUserCode(SecurityUtils.getCurrentUserId());
        //查询门店邀请码是否存在
        int result = storeInvestDao.queryExistInvest(investCode);
        if(result == 0){
            return AppResponse.paramError("门店邀请码不存在!");
        }
        //查询用户是否已经绑定门店，如果没有，那么新增绑定门店
        int count = storeInvestDao.queryCountBindStore(investCode);
        if(count > 0){
            //说明已经绑定了，只需要 修改绑定的店铺邀请码 就行
            //邀请码修改
            result = storeInvestDao.updateUserInvest(investCode);
            if(result > 0){
                return AppResponse.success("门店邀请码绑定更新成功!");
            }
        }else{
            //没有绑定，新增门店绑定信息 先获取新增绑定门店所需要的信息
            BindStore bindStore = storeInvestDao.queryBindData(investCode.getInvitationCode());
            //生成绑定随机编号
            bindStore.setBindCode(RandomCode.radmonkey());
            //赋值
            bindStore.setCreateUser(SecurityUtils.getCurrentUserUsername());
            bindStore.setUserCode(SecurityUtils.getCurrentUserId());
            //新增
            result = storeInvestDao.addUserBind(bindStore);
            if(result > 0){
                return AppResponse.success("绑定店铺成功!");
            }
        }
        return AppResponse.bizError("门店邀请码绑定失败!");
    }
}
