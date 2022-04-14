package com.newkewang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaozhi
 * @description
 * @create 2022-03-2022/3/21 21:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     *  主键
     */
    private Integer id;
    /**
     *  用户名
     */
    private String username;
    /**
     *  密码
     */
    private String password;
    /**
     *  名字
     */
    private String salt;
    /**
     *  邮箱
     */
    private String email;
    /**
     *  类型：0-普通用户；1-超级管理员；2-版主
     */
    private Integer type;
    /**
     *  是否激活：0-未激活；1-已激活
     */
    private Integer status;
    /**
     *  激活码
     */
    private String activationCode;
    /**
     *  头像地址
     */
    private String headerUrl;
    /**
     *  创建时间
     */
    private Date createTime;
}
