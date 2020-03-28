package com.lsx.gateway.feign;

import com.lsx.base.vo.BaseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-user")
public interface TokenFeign {

    @GetMapping(name = "测试跨服务调用", value = "/test")
    BaseVo testUserFeign();
}
