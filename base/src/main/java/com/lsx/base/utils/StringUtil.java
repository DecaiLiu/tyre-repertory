package com.lsx.base.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:字符串
 * @Author: ldc
 * @Date: 2018-10-25
 **/
public class StringUtil {

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }
}
