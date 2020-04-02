package com.lsx.tyre.service;

import com.lsx.base.vo.BaseVo;
import com.lsx.tyre.bean.Dict;

/**
 * @author decai.liu
 * @desc 字典项接口
 * @date 2020/03/30
 */
public interface DictService {
    /**
     * 新增
     * @param toAdd
     */
    void add(Dict toAdd);

    /**
     * 查询字典
     * @param type
     * @return
     */
    BaseVo findByType(Integer type);
}
