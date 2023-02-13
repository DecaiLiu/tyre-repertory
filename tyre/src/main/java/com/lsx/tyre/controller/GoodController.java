package com.lsx.tyre.controller;

import com.lsx.base.common.enums.DictTypeEnum;
import com.lsx.base.support.Authorization;
import com.lsx.base.vo.BaseVo;
import com.lsx.tyre.bean.Dict;
import com.lsx.tyre.service.DictService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(name = "商品管理服务Api")
@Slf4j
public class GoodController {

    @Resource
    private DictService dictService;

    // ================================================= 字典 ==================================================

    @HystrixCommand
    @PostMapping(name = "新增轮胎类型", path = "/dict/add-tyre")
    @Authorization
    public BaseVo addTyre(@RequestBody @Validated Dict dict) {
        Dict toAdd = new Dict();
        toAdd.setName(dict.getName());
        toAdd.setDescription(dict.getDescription());
        toAdd.setType(DictTypeEnum.GOOD_TYPE.value);
        dictService.add(toAdd);
        return new BaseVo();
    }

    @HystrixCommand
    @GetMapping(name = "查询字典项列表", path = "/dict/types")
    public BaseVo listDictTypes() {
        return new BaseVo(DictTypeEnum.list);
    }

    @HystrixCommand
    @PostMapping(name = "新增客户类型", path = "/dict/add-customer")
    @Authorization
    public BaseVo addCustomer(@RequestBody @Validated Dict dict) {
        Dict toAdd = new Dict();
        toAdd.setName(dict.getName());
        toAdd.setDescription(dict.getDescription());
        toAdd.setType(DictTypeEnum.CUSTOMER_TYPE.value);
        dictService.add(toAdd);
        return new BaseVo();
    }

    @HystrixCommand
    @GetMapping(name = "查询某类型字典", path = "/dict/types/{type}")
    public BaseVo getDict(@PathVariable("type") Integer type) {
        return dictService.findByType(type);
    }

    // ======================================================= 库存 ========================================

}
