package com.xzsd.pc.customer.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.entity.User;
import com.xzsd.pc.util.SecurityUtils;
import org.springframework.stereotype.Service;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.Customer;
import javax.annotation.Resource;
import java.util.List;
/**
 * @DescriptionDemo 顾客服务类
 * @Author zhc
 * @Date 2020-03-26
 */
@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;
    /**
     * 客户列表查询
     * @param customer
     * @return
     */
    public AppResponse queryCustomer(Customer customer){
        //查询分页参数是否为空
        if(customer.getPageNum() == 0 || customer.getPageSize() == 0){
            return AppResponse.paramError( "页号或者页数量不能为空!");
        }
        //从Redis中根据Token获取当前用户编号，由于登入没写，所以这里指定一个账号进行测试
        String userCode = SecurityUtils.getCurrentUserUsername();
        customer.setUserCode(userCode);
        //查询用户角色
        User queryUser = customerDao.queryCurrUser(customer.getUserCode());
        //如果查询不到当前用户，则返回错误
        if(null == queryUser){
            //说明是司机
            return AppResponse.paramError("查询为空或者司机不能查看!");
        }
        customer.setUserRole(queryUser.getUserRole());
        customer.setUserCode(queryUser.getUserCode());
        //分页查询
        PageHelper.startPage(customer.getPageNum(),customer.getPageSize());
        List<Customer> customerList= customerDao.queryCustomer(customer);
        PageInfo<Customer>customerPageInfo = new PageInfo<>(customerList);
        if(customerList.size() > 0){
            return AppResponse.success("查询成功!",customerPageInfo);
        }
        return AppResponse.paramError("查询为空!");
    }
}
