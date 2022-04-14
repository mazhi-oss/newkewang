package com.newkewang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaozhi
 * @description 登录凭证
 * @create 2022-03-2022/3/24 21:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginTicket {

    /**
     *  主键
     */
    private Integer id;
    /**
     *  用户ID
     */
    private Integer userId;
    /**
     *  凭证
     */
    private String ticket;
    /**
     *  状态
     */
    private Integer status;
    /**
     *  过期时间
     */
    private Date expired;
}
