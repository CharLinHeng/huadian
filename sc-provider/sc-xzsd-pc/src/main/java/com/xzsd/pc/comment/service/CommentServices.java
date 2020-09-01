package com.xzsd.pc.comment.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.comment.dao.CommentDao;
import com.xzsd.pc.comment.entity.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 商品评价服务层
 * @author 64631
 */
@Service
public class CommentServices {

    @Resource
    private CommentDao commentDao;
    /**
     * demo 查询评论列表（分页）
     * @param comment
     * @return AppResponse
     * @Author feng
     * @Date 2020-08-31
     */
    public AppResponse listComments (Comment comment){
        PageHelper.startPage(comment.getPageNum(), comment.getPageSize());
        List<Comment> goodsInfoList = commentDao.listComments(comment);
        // 包装Page对象
        PageInfo<Comment> pageData = new PageInfo<Comment>(goodsInfoList);
        return AppResponse.success("查询成功！", pageData);
    }
    /**
     * 删除评论
     *
     * @param evaCode,userCode
     * @return AppResponse
     * @author feng
     * @date 2020-08-31
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteComments(String userCode, String evaCode) {
        List<String> listCode = Arrays.asList(evaCode.split(","));
        // 删除商品
        int count = commentDao.deleteComments(listCode, userCode);
        AppResponse appResponse = AppResponse.success("删除成功！");
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
