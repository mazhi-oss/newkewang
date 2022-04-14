package com.newkewang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author xiaozhi
 * @description
 * @create 2022-03-2022/3/21 22:04
 */
@MapperScan(basePackages = "com.newkewang.mapper")
@Configurable
public class MybatisConfig {

}
