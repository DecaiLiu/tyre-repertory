package com.lsx.base.common.constant;

/**
 * @desc 全局字符串常量
 * @author decai.liu
 * @date 2020/03/24
 */
public class GlobalConstants {

    // 手机号
    public static final String REGEX_PHONE = "^1[3456789]\\d{9}$";

    // 车牌号规则，仅能识别大部分常规车牌
    public static final String REGEX_CARNO = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[警京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{0,1}[A-Z0-9]{4,5}[A-Z0-9挂学警港澳]{1}$";
}
