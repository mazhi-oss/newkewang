package com.newkewang.controller.interceptor;

import com.newkewang.entity.User;
import com.newkewang.service.DataService;
import com.newkewang.utils.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaozhi
 * @description 统计用户DAU和网站UV
 * @create 2022-05-2022/5/15 17:10
 */
@Component
public class DataInterceptor implements HandlerInterceptor {

    @Autowired
    private DataService dataService;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 统计网站UV
        String ip = request.getRemoteHost();
        dataService.recordUV(ip);

        // 统计用户DAU
        User user = hostHolder.getUser();
        if (user != null) {
            dataService.recordDAU(user.getId());
        }
        return true;
    }
}
