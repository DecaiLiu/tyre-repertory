package com.lsx.tyre.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 字典项
 *
 * @author decai.liu
 */
@Data
public class Dict implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 字典类型（0：性别，1：轮胎，2：客户类型，3：付款状态）
     */
    private Integer type;

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;

}