package com.newkewang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaozhi
 * @description 私信类
 * @create 2022-03-2022/3/28 19:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer id;
    /**
     * 私信发送者ID
     */
    private Integer fromId;
    /**
     * 私信接受者ID
     */
    private Integer toId;
    /**
     * 会话ID
     */
    private String conversationId;
    /**
     * 私信内容
     */
    private String content;
    /**
     * 已读或未读：0-未读，1-已读
     */
    private Integer status = 0;
    private Date createTime;
}
