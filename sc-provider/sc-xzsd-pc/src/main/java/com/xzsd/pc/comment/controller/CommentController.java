package com.xzsd.pc.comment.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.comment.entity.Comment;
import com.xzsd.pc.comment.service.CommentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * 商品评价控制层
 * @author 64631
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Resource
    private CommentServices commentServices;
    /**
     * 查询评价列表
     *
     * @param comment
     * @return AppResponse
     * @author feng
     * @Date 2020-08-31
     */
    @PostMapping("listComments")
    public AppResponse listComments(Comment comment) {
        try {
            return commentServices.listComments(comment);
        } catch (Exception e) {
            logger.error("查询评价列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除评论
     *
     * @param evaCode
     * @return AppResponse
     * @author feng
     * @date 2020-08-31
     */
    @PostMapping("deleteComments")
    public AppResponse deleteComments(String evaCode) {
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            return commentServices.deleteComments(userCode, evaCode);
        }catch (Exception e){
            logger.error("删除评价列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

