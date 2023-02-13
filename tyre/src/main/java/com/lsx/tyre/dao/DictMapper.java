package com.lsx.tyre.dao;

import com.lsx.tyre.bean.Dict;

import java.util.List;

public interface DictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    List<Dict> selectByType(Integer type);
}