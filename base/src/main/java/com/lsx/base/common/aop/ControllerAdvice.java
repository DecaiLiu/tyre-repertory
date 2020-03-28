package com.lsx.base.common.aop;

import com.lsx.base.common.ResultCode;
import com.lsx.base.exception.BusinessException;
import com.lsx.base.exception.CheckException;
import com.lsx.base.vo.BaseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局的 controller异常处理
 * @Author: ldc
 * @Date: 2018-11-06
 **/
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return vo
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseVo errorHandler(Exception ex) {
        BaseVo vo = new BaseVo();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            if (businessException.getCode() > 0) {
                vo.setCode(businessException.getCode());
            } else {
                vo.setCode(ResultCode.WRONG.getCode());
            }
            vo.setMsg(ex.getMessage());

        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException mex = (MethodArgumentNotValidException) ex;
            vo.setCode(ResultCode.PARAMETER_ERROR.getCode());
            vo.setMsg(mex.getBindingResult().getFieldError().getDefaultMessage());
        } else if (ex instanceof CheckException) {
            vo.setCode(ResultCode.PARAMETER_ERROR.getCode());
            vo.setMsg(ex.getMessage());
        } else {
            vo.setCode(ResultCode.WRONG.getCode());
            vo.setMsg(ResultCode.WRONG.getInfo());
        }
        logger.error(ex.getMessage(), ex);
        return vo;
    }

}
