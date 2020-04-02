package com.lsx.tyre.dao;

import com.lsx.tyre.bean.OrderDetail;

public interface OrderDetailMapper {
    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);
}