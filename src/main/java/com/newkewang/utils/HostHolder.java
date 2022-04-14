package com.newkewang.utils;

import com.newkewang.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author xiaozhi
 * @description 持有用户信息，由于代替session对象.
 * @create 2022-03-2022/3/25 20:37
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }


}
