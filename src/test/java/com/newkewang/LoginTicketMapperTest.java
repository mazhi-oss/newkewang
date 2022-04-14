package com.newkewang;

import com.newkewang.entity.LoginTicket;
import com.newkewang.mapper.LoginTicketMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.AttributeSet;
import java.util.Date;

/**
 * @author xiaozhi
 * @description
 * @create 2022-03-2022/3/24 22:08
 */
@SpringBootTest
public class LoginTicketMapperTest {

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectByTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Test
    public void testUpdateStatus(){
        int i = loginTicketMapper.updateStatus("abc", 1);
        System.out.println(i);
    }

    @Test
    public void test(){

    }
}
