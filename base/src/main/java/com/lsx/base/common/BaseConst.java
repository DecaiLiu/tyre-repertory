package com.lsx.base.common;

/**
 * @Description: 静态类
 * @Author: ldc
 **/
public class BaseConst {

    /**
     * 是否过滤请求,不过滤
     */
    public static final String NO_FILTER = "1";


    /**
     * 是否过滤请求,过滤
     */
    public static final String FILTER = "0";

    /**
     * token 缓存名称
     */
    public static final String CACHE_NAME_TOKEN = "TOKEN";

    /**
     * app uid缓存名称
     */
    public static final String CACHE_NAME_APP_UID = "APP_UID";

    /**
     * 请求头中是否过滤标识的  key
     */
    public static final String FILTER_FLAG = "requestType";

    /*
        限流过期秒数
     */
    public static final int LIMIT_EXPIRE_SECOND = 1;

    /*
       限流key
    */
    public static final String LIMIT_REDIS_KEY_PREFIX = "limit:rate";
    /*
        限流请求个数
     */
    public static final int LIMIT_RATE = 60;
}
