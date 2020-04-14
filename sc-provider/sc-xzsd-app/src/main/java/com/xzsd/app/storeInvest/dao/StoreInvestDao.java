package com.xzsd.app.storeInvest.dao;

import com.xzsd.app.storeInvest.entity.InvestCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreInvestDao {
    /**
     * 修改邀请码
     * @param investCode
     * @return
     */
    int updateUserInvest(InvestCode investCode);
}
