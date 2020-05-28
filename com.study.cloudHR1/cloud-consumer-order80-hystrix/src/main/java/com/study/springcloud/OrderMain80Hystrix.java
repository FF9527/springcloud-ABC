package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author:wuqi
 * @date:2020/5/16
 * @description:com.study.springcloud
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderMain80Hystrix {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80Hystrix.class,args);
    }
}
