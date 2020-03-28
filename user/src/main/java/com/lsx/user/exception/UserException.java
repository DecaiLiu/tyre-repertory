package com.lsx.user.exception;

import com.lsx.base.exception.BusinessException;

/**
 * @author decai.liu
 * @desc
 * @date 2020/03/24
 */
public class UserException extends BusinessException {
    public UserException(String message) {
        super(message);
    }

    public UserException(String message, int code) {
        super(message, code);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public static final UserException PHONE_REGISTERED = new UserException("手机号已被注册", 840001);
    public static final UserException USER_NOT_EXIST = new UserException("用户不存在", 840002);
    public static final UserException LOGIN_FAIL = new UserException("账号或密码不正确", 840003);

}
