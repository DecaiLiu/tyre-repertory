package com.lsx.tyre.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 *
 * @author decai.liu
 */
@Data
public class Order implements Serializable {
    /**
     * 订单号
     */
    private Long id;

    /**
     * 订单状态（待发货，已发货，已签收，已拒收）
     */
    private Long status;

    /**
     * 订单类型（进货，出货）
     */
    private Long orderType;

    /**
     * 支付状态（已支付，未支付）
     */
    private Long payStatus;

    /**
     * 订单描述
     */
    private String description;

    /**
     * 应收价
     */
    private Double receivable;

    /**
     * 实收价
     */
    private Double realPrice;

    /**
     * 下单时间
     */
    private Date orderAt;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

    /**
     * 是否删除
     */
    private Integer deleted;

    private static final long serialVersionUID = 1L;
}