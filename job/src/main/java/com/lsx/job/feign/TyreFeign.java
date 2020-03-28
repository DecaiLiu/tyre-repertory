package com.lsx.job.feign;

import com.lsx.base.vo.BaseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description :
 * @Date ： 2019/3/21 18:32
 */
@FeignClient(value = "service-tyre")
public interface TyreFeign {

    @GetMapping(value = "/tyre/test-job")
    BaseVo test(Long id);
}
