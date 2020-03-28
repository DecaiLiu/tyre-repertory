package com.lsx.base.common.aop;


import com.lsx.base.common.ResultCode;
import com.lsx.base.utils.JSONUtil;
import com.lsx.base.vo.BaseVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一进行aop 拦截，可以打印日志，在各个模块手动加载
 *
 * @author ldc
 */
@Aspect
public class GlobalApiAop {

    private static final Logger logger = LoggerFactory.getLogger(GlobalApiAop.class);

    @Pointcut("execution(* com.lsx.*.controller.*.*(..))")
    public void executeService() {
    }

    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        if (!isInclude(uri)) {
            logger.info("\n请求开始, 参数-> url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
        }

        String simpleName = point.getTarget().getClass().getSimpleName();
        String methodName = point.getSignature().getName();

        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();

        Object[] param = point.getArgs();

        if (param != null && !isInclude(uri)) {
            for (int i = 0; i < param.length; i++) {
                if (param[i] instanceof BindingResult) {
                    BindingResult bindingResult = (BindingResult) param[i];
                    if (bindingResult.hasErrors()) {
                        StringBuilder sb = new StringBuilder();
                        for (FieldError error : bindingResult.getFieldErrors()) {
                            sb.append(error.getDefaultMessage()).append(",");
                        }
                        sb.deleteCharAt(sb.lastIndexOf(","));
                        BaseVo baseVo = new BaseVo();
                        baseVo.setMsg(sb.toString());
                        baseVo.setCode(ResultCode.PARAMETER_ERROR.getCode());
                        return baseVo;
                    }
                }
            }
        }

        // 开始处理方法
        Object result = point.proceed();
        if (!isInclude(uri)) {
            logger.info("\n 接口返回值:{}", JSONUtil.toJSONString(result));
        }
        return result;
    }

    /**
     * 是否需要过滤
     *
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
//        for (String pattern : Const.AOP_URI) {
//            if (url.indexOf(pattern) != -1) {
//                return true;
//            }
//        }
        return false;
    }
}