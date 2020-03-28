package com.lsx.base.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author decai.liu
 * @desc 用户token信息
 * @date 2020/03/24
 */
@Data
public class TokenDTO implements Serializable {
    private String token;
    private Long uid;

    public TokenDTO() {
    }

    public TokenDTO(String token, Long uid) {
        this.token = token;
        this.uid = uid;
    }
}
