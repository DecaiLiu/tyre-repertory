package com.lsx.base.common;

/**
 * @Description: 返回的类型的枚举类
 * @Author: ldc
 * @Date: 2018-09-17
 **/
public enum ResultCode {

    /**
     * 操作成功
     */
    SUCCESS(0, "成功"),

    /**
     * 操作失败
     */
    WRONG(1, "操作失败"),

    /**
     * 未授权
     */
    UNAUTH(401, "未授权"),

    /**
     * 参数错误
     */
    PARAMETER_ERROR(400, "参数错误"),

    /**
     * 内部调用RPC返回
     */
    HYSTRIX_TIME_OUT(-1, "未授权");

    /**
     * 操作码
     */
    private int code;

    /**
     * 操作信息
     */
    private String info;

    /**
     * @param code 状态码
     * @param info 状态信息
     */
    ResultCode(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }


    public String getInfo() {
        return info;
    }
}
