package com.lsx.user.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static com.lsx.base.common.constant.GlobalConstants.REGEX_PHONE;

/**
 * @author decai.liu
 * @desc 用户实体
 * @date 2020/03/24
 */
@Data
public class User implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Length(min = 2, max = 10, message = "姓名长度(2~10)不符合")
    private String name;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = REGEX_PHONE, message = "手机号输入有误")
    private String phone;

    /**
     * 性别(1：男，2：女)
     */
    @NotNull(message = "性别不能为空")
    private Integer sex;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "密码长度需为6~16个字符")
    private String password;

    private static final long serialVersionUID = 1L;
}