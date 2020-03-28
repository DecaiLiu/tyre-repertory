package com.lsx.base.common.enums;

/**
 * @Description: 静态类
 * @Author: ldc
 **/
public enum RedisKey {

    /**
     * 用户 token 前缀
     */
    USER_APP_KEY("{0}_{1}_token"),

    /**
     * 用户 app token前缀
     */
    USER_APP_TOKEN_KEY("{0}_{1}_{2}");

    /**
     * 操作信息
     */
    private String key;

    /**
     * @param key 状态信息
     */
    RedisKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
