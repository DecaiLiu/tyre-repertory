package com.lsx.tyre.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 库存
 *
 * @author decai.liu
 * @date 2020/03/30
 */
@Data
public class Repertory implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long goodId;

    /**
     * 商品年月（202005）
     */
    private Integer goodYear;

    /**
     * 总数量
     */
    private Integer totalNum;

    /**
     * 已售数量
     */
    private Integer soldNum;

    /**
     * 剩余数量
     */
    private Integer residueNum;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

    private static final long serialVersionUID = 1L;
}