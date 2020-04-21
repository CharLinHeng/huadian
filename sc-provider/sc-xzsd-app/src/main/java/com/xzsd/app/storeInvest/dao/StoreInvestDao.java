package com.xzsd.app.storeInvest.dao;

import com.xzsd.app.storeInvest.entity.BindStore;
import com.xzsd.app.storeInvest.entity.InvestCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreInvestDao {
    /**
     * 修改邀请码
     * @param investCode
     * @return
     */
    int updateUserInvest(InvestCode investCode);

    /**
     * 查询门店邀请码是否存在
     * @param investCode
     * @return
     */
    int queryExistInvest(InvestCode investCode);

    /**
     * 新增绑定门店信息
     * @param bindStore
     * @return
     */
    int addUserBind(BindStore bindStore);

    /**
     * 根据邀请码查询相关门店信息 ，为了新增绑定
     * @return
     */
    BindStore queryBindData(@Param("bindInverstCode")String bindCode);

    /**
     * 查询这个用户是否已经绑定门店，
     * @param bindStore
     * @return
     */
    int queryCountBindStore(InvestCode bindStore);
}
