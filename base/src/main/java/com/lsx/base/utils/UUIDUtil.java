package com.lsx.base.utils;

import java.util.UUID;

/**
 * @Description:生成随机字符串的工具类
 * @Author: ldc
 * @Date: 2018-10-16
 **/
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
