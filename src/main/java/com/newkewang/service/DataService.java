package com.newkewang.service;

import com.newkewang.utils.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xiaozhi
 * @description 数据统计
 * @create 2022-05-2022/5/14 17:01
 */
@Service
public class DataService {

    @Autowired
    private RedisTemplate redisTemplate;

    private SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    /**
     * 将指定ip计入UV
     * @param ip
     */
    public void recordUV(String ip) {
        String uvKey = RedisKeyUtil.getUVKey(df.format(new Date()));
        redisTemplate.opsForHyperLogLog().add(uvKey, ip);
    }

    /**
     * 统计指定日期范围内的key
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public long calculateUV(Date start, Date end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

        // 整理该日期范围内的key
        List<String> keyList = new ArrayList<>();
        // 创建日历对象
        Calendar calendar = Calendar.getInstance();
        // 设置日期
        calendar.setTime(start);
        // 判断是否超过结束日期
        while (!calendar.after(end)) {
            // 获取redis的key
            String key = RedisKeyUtil.getDAUKey(df.format(calendar.getTime()));
            keyList.add(key);
            // 天数加1
            calendar.add(Calendar.DATE, 1);
        }

        // 合并这些数据
        String uvKey = RedisKeyUtil.getUVKey(df.format(start), df.format(end));
        redisTemplate.opsForHyperLogLog().add(uvKey, keyList.toArray());

        // 返回统计结果
        return redisTemplate.opsForHyperLogLog().size(uvKey);
    }


}
