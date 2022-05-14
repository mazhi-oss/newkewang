package com.newkewang;

import com.newkewang.utils.MailClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author xiaozhi
 * @description
 * @create 2022-03-2022/3/24 16:53
 */
@SpringBootTest
public class TestMailSend {

    /**
     * 注入template引擎
     */
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private MailClient mailClient;

    @Test
    public void testSendHtml(){
        Context context = new Context();
        context.setVariable("username", "xiaozhi");
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);
        // 发送html到邮箱
//        mailClient.sendMail("1596971466@qq.com", "HTML", content);
    }


}
