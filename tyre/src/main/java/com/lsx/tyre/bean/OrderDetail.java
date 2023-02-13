package com.lsx.tyre.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情
 *
 * @author decai.liu
 */
@Data
public class OrderDetail implements Serializable {
    /**
     * 订单流水号
     */
    private Long id;

    /**
     * 商品id
     */
    private Long goodId;

    /**
     * 商品name
     */
    private String goodName;

    /**
     * 商品年月（202010）
     */
    private Integer goodYear;

    /**
     * 商品数量
     */
    private Integer goodNum;

    /**
     * 商品单价
     */
    private Double price;

    /**
     * 发货时间
     */
    private Date sendAt;

    /**
     * 签收时间（签收/拒收）
     */
    private Date signAt;

    /**
     * 支付方式（现金，微信，支付宝）
     */
    private Long payMethod;

    /**
     * 支付时间
     */
    private Date payAt;

    /**
     * 配送方式（现场，急送，邮寄）
     */
    private Long sendWay;

    /**
     * 配送地址
     */
    private String sendAddress;

    /**
     * 邮寄运货单号
     */
    private String waybillNum;

    /**
     * 客户（散客，合作伙伴）
     */
    private Long customerType;

    /**
     * 客户称呼
     */
    private String customerName;

    /**
     * 客户联系电话
     */
    private String customerPhone;

    /**
     * 订单备注，签收/拒收信息
     */
    private String remark;

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