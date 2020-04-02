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
@RequestMapping(name = "轮胎服务Api")
@Slf4j
public class TyreController {

    @Resource
    private DictService dictService;

    // ================================================= 字典 ==================================================

    @HystrixCommand
    @GetMapping(name = "查询字典类型", path = "/dict/add-tyre")
    public BaseVo addTyre(@RequestBody @Validated Dict dict) {
        Dict toAdd = new Dict();
        toAdd.setName(dict.getName());
        toAdd.setDescription(dict.getDescription());
        toAdd.setType(DictTypeEnum.TYRE_TYPE.value);
        dictService.add(toAdd);
        return new BaseVo();
    }

    @HystrixCommand
    @PostMapping(name = "新增轮胎类型", path = "/dict/types")
    @Authorization
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
    @GetMapping(name = "查询字典项", path = "/dict/{type}")
    public BaseVo getDict(@PathVariable("type") Integer type) {
        return dictService.findByType(type);
    }

    // ======================================================= 库存 ========================================

}
