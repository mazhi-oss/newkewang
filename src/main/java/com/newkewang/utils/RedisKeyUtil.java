package com.newkewang.utils;

import org.springframework.stereotype.Component;

/**
 * @author xiaozhi
 * @description 生成redis的key
 * @create 2022-03-2022/3/30 15:02
 */
@Component
public class RedisKeyUtil {

    /**
     * 分隔符
     */
    private static final String SPLIT = ":";
    /**
     * 点赞前缀
     */
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    /**
     * 用户前缀
     */
    private static final String PREFIX_ENTITY_USER = "like:user";
    /**
     * 关注前缀
     */
    private static final String PREFIX_FOLLOWEE = "followee";
    private static final String PREFIX_FOLLOWER = "follower";
    /**
     * 验证码前缀
     */
    private static final String PREFIX_KAPTCHA = "kaptcha";
    /**
     * 验证码前缀
     */
    private static final String PREFIX_TICKET = "ticket";
    /**
     * 验证码前缀
     */
    private static final String PREFIX_USER = "user";


    /**
     * 某个实体的赞
     * eg：like:entity:entityType:entityId -> set(userId)
     * @param entityType
     * @param entityId
     * @return
     */
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    /**
     * 某个用户的赞
     * @param userId
     * @return
     */
    public static String getUserLikeKey(int userId) {
        return   PREFIX_ENTITY_LIKE + SPLIT + userId;
    }

    /**
     * 某个用户关注的实体
     * followee:userId:entityType -> zset(entityId, now)
     */
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    /**
     * 某个实体拥有的粉丝
     * follower:entityType:entityId -> zset(userId, now)
     */
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }

    /**
     * 登录验证码
     */
    public static String getKaptchaKey(String owner) {
        return PREFIX_KAPTCHA + SPLIT + owner;
    }

    /**
     * 登录的凭证
     */
    public static String getTicketKey(String ticket) {
        return PREFIX_TICKET + SPLIT + ticket;
    }
    /**
     * 用户
     */
    public static String getUserKey(int userId) {
        return PREFIX_USER + SPLIT + userId;
    }
}
