package com.xzsd.app.storeInvest.controller;

import com.xzsd.app.passWord.entity.PassWord;
import com.xzsd.app.passWord.service.PassWordService;
import com.xzsd.app.storeInvest.entity.InvestCode;
import com.xzsd.app.storeInvest.service.StoreInvestService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 邀请码修改
 */
@RestController
@RequestMapping("/customer")
public class StoreInvestController {
    @Resource
    private StoreInvestService storeInvestService;
    /**
     * 修改密码
     * @param investCode
     * @return
     */
    @ResponseBody
    @PostMapping("updateUserInvest")
    public ResponceData updateUserPassword(InvestCode investCode){
        try{
            return storeInvestService.updateUserInvest(investCode);
        }catch (Exception e){
            throw e;
        }
    }
}
