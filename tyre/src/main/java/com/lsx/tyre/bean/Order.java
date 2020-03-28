package com.lsx.tyre.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author decai.liu
 * @date 2020/03/24
 */
public class Order implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 订单流水号
     */
    private String seqnum;

    /**
     * 轮胎类型
     */
    private Long tyreType;

    /**
     * 轮胎数量
     */
    private Integer tyreNum;

    /**
     * 轮胎单价
     */
    private Double tyrePrice;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 实际价
     */
    private Double realPrice;

    /**
     * 订单描述
     */
    private String description;

    /**
     * 支付状态（已支付，未支付）
     */
    private Long payStatus;

    /**
     * 支付方式（现金，微信，支付宝）
     */
    private Long payMethod;

    /**
     * 支付时间
     */
    private Date payAt;

    /**
     * 订单类型（进货，出货）
     */
    private Long orderType;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeqnum() {
        return seqnum;
    }

    public void setSeqnum(String seqnum) {
        this.seqnum = seqnum == null ? null : seqnum.trim();
    }

    public Long getTyreType() {
        return tyreType;
    }

    public void setTyreType(Long tyreType) {
        this.tyreType = tyreType;
    }

    public Integer getTyreNum() {
        return tyreNum;
    }

    public void setTyreNum(Integer tyreNum) {
        this.tyreNum = tyreNum;
    }

    public Double getTyrePrice() {
        return tyrePrice;
    }

    public void setTyrePrice(Double tyrePrice) {
        this.tyrePrice = tyrePrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Long payStatus) {
        this.payStatus = payStatus;
    }

    public Long getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Long payMethod) {
        this.payMethod = payMethod;
    }

    public Date getPayAt() {
        return payAt;
    }

    public void setPayAt(Date payAt) {
        this.payAt = payAt;
    }

    public Long getOrderType() {
        return orderType;
    }

    public void setOrderType(Long orderType) {
        this.orderType = orderType;
    }

    public Date getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(Date orderAt) {
        this.orderAt = orderAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", seqnum=").append(seqnum);
        sb.append(", tyreType=").append(tyreType);
        sb.append(", tyreNum=").append(tyreNum);
        sb.append(", tyrePrice=").append(tyrePrice);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", realPrice=").append(realPrice);
        sb.append(", description=").append(description);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", payAt=").append(payAt);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderAt=").append(orderAt);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}