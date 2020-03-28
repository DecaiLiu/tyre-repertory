package com.lsx.user.interceptor;

import com.lsx.base.common.enums.RedisKey;
import com.lsx.base.dto.AppDTO;
import com.lsx.base.support.Authorization;
import com.lsx.base.utils.CacheUtil;
import com.lsx.base.utils.RedisKeyUtil;
import com.lsx.base.utils.SessionUtil;
import com.lsx.base.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

import static com.lsx.base.exception.BusinessException.PERMISSION_DENIED;
import static com.lsx.base.exception.BusinessException.TOKEN_INVALID;

/**
 * @author decai.liu
 * @desc token 校验
 * @date 2020/03/24
 */
public class TokenInterceptor implements HandlerInterceptor, InitializingBean {
    @Resource
    private CacheUtil cacheUtil;

    @Value("${single.login}")
    private boolean singleLogin;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod))
            return true;

        // 处理token验证
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 获取方法上的Authorization注解
        Authorization authAnnotation = this.getMethodAuthAnnotation(handlerMethod.getMethod());

        // 如果方法上没有标注Authorization，说明无需做鉴权，直接返回
        if (authAnnotation == null) {
            return true;
        }

        String token = request.getHeader(authAnnotation.tokenField());
        String uid = request.getHeader(authAnnotation.uidField());
        token = StringUtils.isBlank(token) ? request.getParameter(authAnnotation.tokenField()) : token;
        uid = StringUtils.isBlank(uid) ? request.getParameter(authAnnotation.uidField()) : uid;
        if (StringUtils.isBlank(token) || StringUtils.isBlank(uid)) {
            throw TOKEN_INVALID;
        }

        Long _uid;
        try {
            _uid = Long.parseLong(uid);
        } catch (NumberFormatException e) {
            throw TOKEN_INVALID;
        }

        AppDTO appDTO = SessionUtil.getAppDTO();

        // 校验 token
        verifyToken(_uid, token, appDTO.getId());

        /**
         * 如 Authorization 注解的 requiredPermissions 字段不为空，则需校验用户权限
         */
        if (authAnnotation.requiredPermissions().length > 0 && !checkPermissions()) {
            throw PERMISSION_DENIED;
        }
        SessionUtil.bindTokenDTO(token, _uid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object handler, Exception e) throws Exception {
    }

    private Authorization getMethodAuthAnnotation(Method method) {
        return method.getAnnotation(Authorization.class);
    }

    /**
     * 校验 token
     *
     * @param uid   用户ID
     * @param token 用户token
     * @param appId 应用ID
     * @return
     */
    private boolean verifyToken(Long uid, String token, Long appId) {
        String userAppTokenKey = RedisKeyUtil.getRedisKey(RedisKey.USER_APP_TOKEN_KEY, uid.toString(), appId.toString(), token);
        String tokenKey = cacheUtil.getAppUidCache().get(userAppTokenKey);
        if (StringUtil.isEmpty(tokenKey)) {
            throw TOKEN_INVALID;
        }
        String oldToken = cacheUtil.getTokenCache().get(tokenKey);
        if (StringUtil.isEmpty(oldToken)) {
            throw TOKEN_INVALID;
        }
        if (singleLogin && !oldToken.equals(token)) {
            throw TOKEN_INVALID;
        }
        return true;
    }

    /**
     * 检查用户权限 TODO
     *
     * @return
     */
    private boolean checkPermissions() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 更新 api 记录
        /*Map<RequestMappingInfo, HandlerMethod> requestMappingInfoMap = requestMappingHandlerMapping.getHandlerMethods();
        List<ApiDTO> apiDTOs = new ArrayList<>(500);
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : requestMappingInfoMap.entrySet()) {
            RequestMappingInfo mappingInfo = entry.getKey();
            HandlerMethod handlerMethod = entry.getValue();
            for (String path : mappingInfo.getPatternsCondition().getPatterns()) {
                if (path.startsWith("/error")) {
                    continue;
                }
                for (RequestMethod method : mappingInfo.getMethodsCondition().getMethods()) {
                    try {
                        ApiMethodEnum apiMethodEnum = ApiMethodEnum.valueOf(method.name());
                        ApiDTO apiDTO = new ApiDTO();
                        apiDTO.setName(mappingInfo.getName());
                        apiDTO.setMethod(apiMethodEnum.value());
                        apiDTO.setPath(path);
                        apiDTO.setDeprecated(handlerMethod.hasMethodAnnotation(Deprecated.class));
                        apiDTOs.add(apiDTO);

                        if (apiDTOs.size() == 500) {
                            systemFacade.saveApis(apiDTOs);
                            apiDTOs.clear();
                        }
                    } catch (IllegalArgumentException e) {
                        // 忽略不支持的RequestMethod
                    }
                }
            }
        }
        if (apiDTOs.size() > 0) {
            systemFacade.saveApis(apiDTOs);
        }*/
    }
}
