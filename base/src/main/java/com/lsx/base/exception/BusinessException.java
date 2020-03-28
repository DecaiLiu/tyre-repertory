package com.lsx.base.exception;

/**
 * @Description:
 * @Author: ldc
 * @Date: 2018-10-25
 **/
public class BusinessException extends RuntimeException {


    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static final BusinessException PERMISSION_DENIED = new BusinessException("权限不足", 800001);

    public static final BusinessException TOKEN_INVALID = new BusinessException("token失效, 请重新登陆", 800002);
}
