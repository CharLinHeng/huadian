package com.xzsd.app.passWord.controller;
import com.xzsd.app.passWord.entity.PassWord;
import com.xzsd.app.passWord.service.PassWordService;
import com.xzsd.app.util.ResponceData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * 修改新增类
 */
@RestController
@RequestMapping("/customer")
public class PassWordController {
    @Resource
    private PassWordService passWordService;
    /**
     * 修改密码
     * @param passWord
     * @return
     */
    @ResponseBody
    @PostMapping("updateUserPassword")
    public ResponceData updateUserPassword(PassWord passWord){
        try{
            return passWordService.updateUserPassword(passWord);
        }catch (Exception e){
            throw e;
        }
    }
}
