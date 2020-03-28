package com.lsx.base.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author decai.liu
 * @desc 用户返回实体
 * @date 2020/03/24
 */
@Data
public class UserVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 性别(1：男，2：女)
     */
    private Integer sex;

    /**
     * token 凭证
     */
    private String token;

    private static final long serialVersionUID = 1L;
}
