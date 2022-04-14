package com.newkewang.mapper;

import com.newkewang.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiaozhi
 * @description
 * @create 2022-03-2022/3/21 21:39
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
