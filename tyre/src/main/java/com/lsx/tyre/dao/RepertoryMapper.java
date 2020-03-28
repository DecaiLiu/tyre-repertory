package com.lsx.tyre.dao;

import com.lsx.tyre.bean.Repertory;

public interface RepertoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Repertory record);

    int insertSelective(Repertory record);

    Repertory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Repertory record);

    int updateByPrimaryKey(Repertory record);
}