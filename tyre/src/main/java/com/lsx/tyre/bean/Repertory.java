package com.lsx.tyre.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author decai.liu
 * @date 2020/03/24
 */
public class Repertory implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 轮胎ID
     */
    private Long tyreId;

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
     * 更新时间
     */
    private Date updateAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTyreId() {
        return tyreId;
    }

    public void setTyreId(Long tyreId) {
        this.tyreId = tyreId;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    public Integer getResidueNum() {
        return residueNum;
    }

    public void setResidueNum(Integer residueNum) {
        this.residueNum = residueNum;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tyreId=").append(tyreId);
        sb.append(", totalNum=").append(totalNum);
        sb.append(", soldNum=").append(soldNum);
        sb.append(", residueNum=").append(residueNum);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}