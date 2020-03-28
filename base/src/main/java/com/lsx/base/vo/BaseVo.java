package com.lsx.base.vo;


import com.lsx.base.common.ResultCode;
import lombok.Data;

/**
 * @Description:基础VO,用于前后端数据传输
 * @Author: ldc
 * @Date: 2018-09-17
 **/
@Data
public class BaseVo<T> {

    /**
     * 操作码
     */
    private int code;

    /**
     * 返回的信息
     */
    private String msg;

    /**
     * 返回的数据
     **/
    private T data;

    public BaseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseVo() {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getInfo();
    }

    public BaseVo(T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getInfo();
        this.data = data;
    }
}
