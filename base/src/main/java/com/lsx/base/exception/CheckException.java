package com.lsx.base.exception;

/**
 * @Description:校验异常类
 * @Author: ldc
 * @Date: 2018-10-25
 **/
public class CheckException extends RuntimeException {

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
