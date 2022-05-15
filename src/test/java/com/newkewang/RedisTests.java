package com.newkewang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisScriptingCommands;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;

/**
 * @author xiaozhi
 * @description
 * @create 2022-03-2022/3/30 3:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewkewangApplication.class)
public class RedisTests {
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testRedis(){
        String redisKey = "test:count";
        redisTemplate.opsForValue().set(redisKey, 1);

        System.out.println(redisTemplate.opsForValue().get(redisKey));
        System.out.println(redisTemplate.opsForValue().increment(redisKey));
        System.out.println(redisTemplate.opsForValue().decrement(redisKey));
    }

    // 编程式事物
    @Test
    public void testRedisTransaction(){
        Object obj = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                String redisKey = "test:tx";
                operations.multi();

                operations.opsForSet().add(redisKey, "zhangsan");
                operations.opsForSet().add(redisKey, "lisi");
                operations.opsForSet().add(redisKey, "wangwu");

                System.out.println(operations.opsForSet().members(redisKey));

                return operations.exec();
            }
        });
        System.out.println(obj);
    }

    // HyperLogLog
    // 统计20万数个重复数据的独立总数
    @Test
    public void testHyperLogLog(){
        HyperLogLogOperations ops = redisTemplate.opsForHyperLogLog();
        String key = "test:hll:01";
        for (int i = 0; i < 1000; i++) {
            ops.add(key, i);
        }

        for (int i = 0; i < 1000; i++) {
            int r = (int) (Math.random() * 1000 + i);
            ops.add(key, r);
        }

        Long size = ops.size(key);
        System.out.println(size);
    }

    // 将三组数据合并，统计三组数据合并后的独立总数
    @Test
    public void testHyperLogLog2(){
        HyperLogLogOperations ops = redisTemplate.opsForHyperLogLog();
        String key = "test:hll:01";
        for (int i = 0; i < 1000; i++) {
            ops.add(key, i);
        }
        String key2 = "test:hll:02";
        for (int i = 500; i < 1500; i++) {
            ops.add(key2, i);
        }
        String key3 = "test:hll:03";
        for (int i = 1000; i < 2000; i++) {
            ops.add(key3, i);
        }

        String unionKey = "test:hll:union";
        ops.union(unionKey, key, key2, key3);
        Long size = ops.size(unionKey);
        System.out.println(size);

    }


    // BitMap
    // 统计一组数据的布尔值
    @Test
    public void testBitMap(){
        String redisKey = "test:bm:01";

        // 记录
        redisTemplate.opsForValue().setBit(redisKey, 1, true);
        redisTemplate.opsForValue().setBit(redisKey, 4, true);
        redisTemplate.opsForValue().setBit(redisKey, 7, true);

        // 查询
        System.out.println(redisTemplate.opsForValue().getBit(redisKey, 0));
        System.out.println(redisTemplate.opsForValue().getBit(redisKey, 1));
        System.out.println(redisTemplate.opsForValue().getBit(redisKey, 2));

        // 统计
        Object obj = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.bitCount(redisKey.getBytes());
            }
        });

        System.out.println(obj);
    }

    // 统计三组的布尔值，并对这3组数据做OR运算
    @Test
    public void testBitMap2(){
        String redisKey2 = "test:bm:02";
        redisTemplate.opsForValue().setBit(redisKey2, 1, true);
        redisTemplate.opsForValue().setBit(redisKey2, 2, true);
        redisTemplate.opsForValue().setBit(redisKey2, 3, true);

        String redisKey3 = "test:bm:03";
        redisTemplate.opsForValue().setBit(redisKey3, 3, true);
        redisTemplate.opsForValue().setBit(redisKey3, 4, true);
        redisTemplate.opsForValue().setBit(redisKey3, 5, true);

        String redisKey4 = "test:bm:04";
        redisTemplate.opsForValue().setBit(redisKey4, 5, true);
        redisTemplate.opsForValue().setBit(redisKey4, 6, true);
        redisTemplate.opsForValue().setBit(redisKey4, 7, true);

        // OR运算
        String redisKey = "test:bm:or";
        Object o = redisTemplate.execute((RedisCallback) con -> {
            con.bitOp(RedisStringCommands.BitOperation.OR,
                    redisKey.getBytes(), redisKey2.getBytes(), redisKey3.getBytes(), redisKey4.getBytes());
            return con.bitCount(redisKey.getBytes());
        });
        System.out.println(o);
    }


}
