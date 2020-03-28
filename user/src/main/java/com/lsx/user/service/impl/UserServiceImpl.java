package com.lsx.user.service.impl;

import com.lsx.base.common.enums.RedisKey;
import com.lsx.base.dto.AppDTO;
import com.lsx.base.service.BaseService;
import com.lsx.base.utils.*;
import com.lsx.base.vo.BaseVo;
import com.lsx.base.vo.UserVO;
import com.lsx.user.bean.User;
import com.lsx.user.dao.UserMapper;
import com.lsx.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

import static com.lsx.user.exception.UserException.LOGIN_FAIL;
import static com.lsx.user.exception.UserException.PHONE_REGISTERED;

/**
 * @author decai.liu
 * @desc
 * @date 2020/03/24
 **/
@Slf4j
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private CacheUtil cacheUtil;

    @Value("${single.login}")
    private boolean singleLogin;

    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    public void add(User user) {
        try {
            // 密码MD5处理
            user.setPassword(MD5Util.compute(user.getPassword()));
            userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            throw PHONE_REGISTERED;
        }
    }

    /**
     * 用户登录
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public BaseVo login(String account, String password) {
        AppDTO appDTO = SessionUtil.getAppDTO();
        User user = userMapper.selectByPhoneAndPassword(account, MD5Util.compute(password));
        if (user == null) {
            throw LOGIN_FAIL;
        }

        // token key
        String tokenRedisKey = RedisKeyUtil.getRedisKey(RedisKey.USER_APP_KEY, user.getId().toString(), appDTO.getId().toString());
        // 如果需要单点登录，则要删除旧的 token、修改登录状态
        String oldToken = singleLogin ? cacheUtil.getAppUidCache().get(tokenRedisKey) : null;
        // 旧的 app token key
        String oldAppTokenKey = RedisKeyUtil.getRedisKey(RedisKey.USER_APP_TOKEN_KEY, user.getId().toString(), appDTO.getId().toString(), oldToken);
        if (StringUtil.isNotEmpty(oldToken)) {
            // 获取旧的授权信息
            String auth = cacheUtil.getAppUidCache().get(oldAppTokenKey);

            // todo 修改登录状态
            log.info("旧的授权信息 auth: {}", auth);
        }

        // 新 token
        String token = UUIDUtil.getUUID();
        CompletableFuture.runAsync(() -> {
            String appTokenKey = RedisKeyUtil.getRedisKey(RedisKey.USER_APP_TOKEN_KEY, user.getId().toString(), appDTO.getId().toString(), token);
            // 单点登陆
            if (StringUtil.isNotEmpty(oldToken)) {
                cacheUtil.getAppUidCache().delete(oldAppTokenKey);
            }
            cacheUtil.getAppUidCache().put(appTokenKey, tokenRedisKey);
            cacheUtil.getTokenCache().put(tokenRedisKey, token);
        });
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        userVO.setToken(token);
        return new BaseVo(userVO);
    }

    /**
     * 查询详情
     *
     * @param uid
     * @return
     */
    @Override
    public UserVO findById(Long uid) {
        User user = userMapper.selectByPrimaryKey(uid);
        if (user == null) {
            log.info("uid:{} 用户不存在。", uid);
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        userVO.setToken(SessionUtil.getTokenDTO().getToken());
        return userVO;
    }
}
