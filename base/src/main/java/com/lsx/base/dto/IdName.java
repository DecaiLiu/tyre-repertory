package com.lsx.base.dto;

import lombok.Data;

/**
 * @Description ID，name
 * @Author ldc
 * @Date 2020/3/18
 **/
@Data
public class IdName {
    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
}
