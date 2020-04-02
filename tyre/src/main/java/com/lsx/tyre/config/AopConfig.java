package com.lsx.tyre.config;

import com.lsx.base.common.aop.GlobalApiAop;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 配置手动加载 api aop 拦截
 *
 * @author ldc
 */
@Configuration
public class AopConfig extends CachingConfigurerSupport {

    @Bean
    public GlobalApiAop getGlobalApiAop() {
        return new GlobalApiAop();
    }
}
