package com.lsx.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Desc
 *
 * @author ldc
 * @date 2020-03-16
 */
@SpringBootApplication(scanBasePackages = "com.lsx")
@MapperScan("com.lsx.user.dao")
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@EnableTransactionManagement
@ServletComponentScan
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableAsync
public class UserApplication {
    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class, args);
    }
}