package com.lsx.user.controller;

import com.lsx.base.support.Authorization;
import com.lsx.base.utils.SessionUtil;
import com.lsx.base.vo.BaseVo;
import com.lsx.base.vo.UserVO;
import com.lsx.user.bean.User;
import com.lsx.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(name = "用户服务Api")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @HystrixCommand
    @PostMapping(name = "用户注册", path = "/register")
    public BaseVo register(@RequestBody @Validated User user) {
        userService.add(user);
        return new BaseVo();
    }

    @HystrixCommand
    @GetMapping(name = "用户登录", path = "/login")
    public BaseVo login(String account, String password) {

        return userService.login(account, password);
    }

    @HystrixCommand
    @GetMapping(name = "查询用户信息", path = "/detail")
    @Authorization
    public BaseVo detail() {
        UserVO userVO = userService.findById(SessionUtil.getTokenDTO().getUid());
        return new BaseVo(userVO);
    }
}
