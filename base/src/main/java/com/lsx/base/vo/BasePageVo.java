package com.lsx.base.vo;


import lombok.Data;

/**
 * @Description:基础分页VO
 * @Author: ldc
 * @Date: 2018-09-17
 **/
@Data
public class BasePageVo<T> extends BaseVo {

    /**
     * 要检索页码.
     */
    private int pageNum = 1;
    /**
     * 每页条数.
     */
    private int pageSize = 10;

    /**
     * 排序的字段
     */
    private String orderBy;

    /**
     * 排序顺序
     */
    private String order;
}
