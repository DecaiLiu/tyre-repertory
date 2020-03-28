package com.lsx.base.vo;

import com.lsx.base.common.ResultCode;
import lombok.Data;

/**
 * @Description:
 * @Author: ldc
 * @Date: 2018-09-17
 **/
@Data
public class Result<T> {


    /**
     * 操作状态码
     */
    private int code;

    /**
     * 操作信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    public Result() {

    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @param code :
     * @param msg  :
     * @return : Result<E>
     * @description:
     * @author ldc
     * @date 2018-09-17
     */
    public static <E> Result<E> fail(int code, String msg) {

        return new Result<E>(code, msg, null);
    }

    /**
     * @param msg :
     * @return : Result<E>
     * @description:
     * @author ldc
     * @date 2018-09-17
     */
    public static <E> Result<E> fail(String msg) {
        return fail(ResultCode.WRONG.getCode(), msg);
    }

    /**
     * @param code :
     * @param msg  :
     * @param data :
     * @return : Result<E>
     * @description:
     * @author ldc
     * @date 2018-09-17
     */
    public static <E> Result<E> timeout(int code, String msg, E data) {

        return new Result<E>(ResultCode.HYSTRIX_TIME_OUT.getCode(), ResultCode.HYSTRIX_TIME_OUT.getInfo(), null);
    }

    /**
     * @param data : 返回数据
     * @return : Result<E>
     * @description:
     * @author ldc
     * @date 2018-09-17
     */
    public static <E> Result<E> success(E data) {
        return new Result<E>(ResultCode.SUCCESS.getCode(), null, data);
    }

    /**
     * @param code    :
     * @param message :
     * @param data    :
     * @return : Result<E>
     * @description:
     * @author ldc
     * @date 2018-09-17
     */
    public static <E> Result<E> success(int code, String message, E data) {
        return new Result<E>(code, message, data);
    }
}
