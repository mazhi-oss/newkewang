package com.newkewang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaozhi
 * @description
 * @create 2022-03-2022/3/23 20:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscussPost {

    private Integer id;
    /**
     *  用户id
     */
    private Integer userId;
    /**
     *  标题
     */
    private String title;
    /**
     *  内容
     */
    private String content;
    /**
     *  文章类型：0-普通；1-置顶
     */
    private Integer type;
    /**
     *  文章状态：0-正常；1-精华；2-拉黑
     */
    private Integer status;
    /**
     *
     */
    private Integer commentCount = 0;
    /**
     *
     */
    private Double score;
    /**
     *
     */
    private Date createTime;
}
