package com.lsx.base.utils;

import com.lsx.base.common.enums.RedisKey;

import java.text.MessageFormat;

/**
 * 根据规则动态组成redisKey
 *
 * @author ldc
 */
public class RedisKeyUtil {

    /**
     * 生成枚举类中指定格式的 key
     * 使用例子: RedisKeyUtil.getRedisKey(RedisKey.USER_APP_KEY, "aaa", "bbb")
     *
     * @param redisKey
     * @param args
     * @return
     */
    public static String getRedisKey(RedisKey redisKey, String... args) {

        String key = redisKey.getKey();
        int len = 0;
        char[] cha = key.toCharArray();
        for (int i = 0; i < cha.length; i++) {
            if (cha[i] == '{') {
                len++;
            }
        }
        if (len != args.length) {
            throw new RuntimeException("redis key 生成出错, 占位符和参数不一致");
        }

        return MessageFormat.format(key, args);
    }

    public static void main(String[] args) {
        System.out.println(getRedisKey(RedisKey.USER_APP_KEY, "1", "2"));
    }

}
