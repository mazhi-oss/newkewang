package com.newkewang;

import com.newkewang.entity.DiscussPost;
import com.newkewang.mapper.DiscussPostMapper;
import com.newkewang.mapper.UserMapper;
import com.newkewang.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;

@SpringBootTest
class NewkewangApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(1);
        System.out.println(user);

        User name = userMapper.selectByName("liubei");
        System.out.println(name);

        User email = userMapper.selectByEmail("1596971466@qq.com");
        System.out.println(email);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("111");
        user.setPassword("123");
        user.setEmail("123@qq.com");
        user.setSalt("abc");
        user.setHeaderUrl("https://www.baidu.com");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        int rows = userMapper.updateStatus(151, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(151, "http//www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(151, "123dsfsd");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

}
