package com.lsx.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author decai.liu
 * @desc web 配置
 * @date 2020/03/24
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    /**
     * token 拦截器
     *
     * @return
     */
    /*@Bean
    public HandlerInterceptor getTokenInterceptor() {
        return new TokenInterceptor();
    }*/

    /**
     * app 拦截器
     *
     * @return
     */
    /*@Bean
    public HandlerInterceptor getAppInterceptor() {
        return new AppInterceptor();
    }*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用于排除拦截

        // app拦截器
//        registry.addInterceptor(getAppInterceptor()).addPathPatterns("/**");

        // token 拦截器
//        registry.addInterceptor(getTokenInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}