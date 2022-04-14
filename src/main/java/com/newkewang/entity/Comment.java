package com.newkewang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author xiaozhi
 * @description 评论类
 * @create 2022-03-2022/3/27 17:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer id;
    /**
     * 发布评论用户ID
     */
    private Integer userId;
    /**
     * 目标评论的类型：1-帖子，2-评论，3-用户，4-题目，4-课程
     */
    private Integer entityType;
    /**
     * 评论目标的ID：在id为222的帖子下评论，那么entityId就为222
     */
    private Integer entityId;
    /**
     * 对评论的评论id
     */
    private Integer targetId = 0;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;

}
