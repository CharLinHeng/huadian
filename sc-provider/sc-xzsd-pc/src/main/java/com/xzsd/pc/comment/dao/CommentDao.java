package com.xzsd.pc.comment.dao;

import com.xzsd.pc.comment.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    /**
     * 查询所有评论信息
     * @param comment 评论信息
     * @return 所有评论信息
     */
    List<Comment> listComments(Comment comment);
    /**
     * 删除评论信息
     * @param listCode 评论编号列表
     * @param userCode 修改人编号
     * @return 删除结果
     */
    int deleteComments(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);

}
