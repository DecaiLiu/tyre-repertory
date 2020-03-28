package com.lsx.base.support;

import java.lang.annotation.*;

/**
 * 用户授权注解，作用于 Controller 方法上.
 * 标注此注解的方法，均需要做 token 校验。即 http request header中需带有 token 和 uid 字段.
 * 如果某方法需要校验权限，那么标注的注解上 requiredPermissions 值写入所需权限的keys,
 * 如: @Authorization(requiredPermissions = {"a","b"})
 * <p>
 * Created by Terry on 2018/1/17
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authorization {

    /**
     * http head token字段名
     *
     * @return
     */
    String tokenField() default "token";

    /**
     * http head uid字段名
     *
     * @return
     */
    String uidField() default "uid";

    /**
     * 方法所需权限
     *
     * @return
     */
    String[] requiredPermissions() default {};

    /**
     * 是否开启 api 权限校验
     *
     * @return
     */
    boolean verifyApi() default true;
}
