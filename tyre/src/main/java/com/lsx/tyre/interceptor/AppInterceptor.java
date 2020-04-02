package com.lsx.tyre.interceptor;

import com.lsx.base.dto.AppDTO;
import com.lsx.base.utils.SessionUtil;
import com.lsx.base.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.lsx.base.exception.BusinessException.PERMISSION_DENIED;

/**
 * @author decai.liu
 * @desc APP拦截器
 * @date 2020/03/24
 */
@Slf4j
public class AppInterceptor implements HandlerInterceptor {

    private static final String HEADER_APP_ID = "app_id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("\nstart user app interceptor...");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        AppDTO app = getApp(request);
        // 缓存app信息
        SessionUtil.bindAppDTO(app);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private AppDTO getApp(HttpServletRequest request) {
        String appIdStr = request.getHeader(HEADER_APP_ID);
        appIdStr = StringUtil.isEmpty(appIdStr) ? request.getParameter(HEADER_APP_ID) : appIdStr;
        if (StringUtil.isEmpty(appIdStr)) {
            throw PERMISSION_DENIED;
        }

        Long appId;
        try {
            appId = Long.parseLong(appIdStr);
        } catch (NumberFormatException e) {
            throw PERMISSION_DENIED;
        }

        // todo 前往DB查询 app 信息
        AppDTO app = new AppDTO();
        app.setId(appId);
        app.setOs(1);
        app.setName("测试");
        return app;
    }
}
