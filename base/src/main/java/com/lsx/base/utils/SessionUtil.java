package com.lsx.base.utils;

import com.lsx.base.dto.AppDTO;
import com.lsx.base.dto.TokenDTO;
import com.lsx.base.utils.thread.RequestThreadBinder;

/**
 * @author decai.liu
 * @desc 本地缓存
 * @date 2020/03/24
 */
public class SessionUtil {

    private static final String USER_KEY = "USER_KEY";

    private static final String APP_KEY = "APP_KEY";

    /**
     * 缓存token信息
     *
     * @param token
     * @param uid
     */
    public static void bindTokenDTO(String token, Long uid) {
        RequestThreadBinder.put(USER_KEY, new TokenDTO(token, uid));
    }

    /**
     * 获取当前token信息
     *
     * @return
     */
    public static TokenDTO getTokenDTO() {
        return (TokenDTO) RequestThreadBinder.get(USER_KEY);
    }

    /**
     * 缓存app信息
     *
     * @param appDTO
     */
    public static void bindAppDTO(AppDTO appDTO) {
        RequestThreadBinder.put(APP_KEY, appDTO);
    }

    /**
     * 获取当前app信息
     *
     * @return
     */
    public static AppDTO getAppDTO() {
        return (AppDTO) RequestThreadBinder.get(APP_KEY);
    }
}
