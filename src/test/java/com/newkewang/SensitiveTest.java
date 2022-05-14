package com.newkewang;

import com.newkewang.utils.SensitiveFilter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xiaozhi
 * @description 测试过滤敏感词
 * @create 2022-03-2022/3/26 16:19
 */
@SpringBootTest
public class SensitiveTest {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter(){
        String text = "这里可以##赌#博#，可以#嫖#娼#，可以吸毒，可以开票，哈哈哈";

        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
