package com.lsx.base.service;

import com.lsx.base.exception.BusinessException;
import com.lsx.base.vo.BaseVo;
import com.lsx.base.vo.SuccessVo;
import com.lsx.base.common.ResultCode;

/**
 * @Description:
 * @Author: ldc
 * @Date: 2018-10-18
 **/
public class BaseService {


    private static SuccessVo successVo = new SuccessVo();

    /**
     * 得到成功Vo,不用每次都new,提高性能
     *
     * @return
     */
    public BaseVo successVo() {
        return successVo;
    }

    /**
     * 优雅抛出异常
     *
     * @param resultCode 返回结果枚举
     * @return
     */
    public void throwBusinessException(ResultCode resultCode) {
        throw new BusinessException(resultCode.getInfo(), resultCode.getCode());
    }

    /**
     * 优雅抛出异常
     *
     * @param exceptionMsg 异常错误信息
     * @return
     */
    public void throwBusinessException(String exceptionMsg) {
        throw new BusinessException(exceptionMsg);
    }
}
