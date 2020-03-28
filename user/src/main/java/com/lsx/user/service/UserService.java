package com.lsx.user.service;

import com.lsx.base.vo.BaseVo;
import com.lsx.base.vo.UserVO;
import com.lsx.user.bean.User;

public interface UserService {

    /**
     * 新增用户
     *
     * @param user
     */
    void add(User user);

    /**
     * 用户登录
     *
     * @param account
     * @param password
     * @return
     */
    BaseVo login(String account, String password);

    /**
     * 查询详情
     *
     * @param uid
     * @return
     */
    UserVO findById(Long uid);
}
