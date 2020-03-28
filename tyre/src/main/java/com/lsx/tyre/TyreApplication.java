package com.lsx.tyre;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@MapperScan("com.lsx.tyre.dao")
@ServletComponentScan
@EnableAsync
public class TyreApplication {
    public static void main(String[] args) {

        SpringApplication.run(TyreApplication.class, args);
    }
}