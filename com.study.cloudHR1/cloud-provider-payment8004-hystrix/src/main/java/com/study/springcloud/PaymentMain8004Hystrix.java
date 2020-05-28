package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author:wuqi
 * @date:2020/5/16
 * @description:com.study.springcloud
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class PaymentMain8004Hystrix {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004Hystrix.class,args);
    }
}
