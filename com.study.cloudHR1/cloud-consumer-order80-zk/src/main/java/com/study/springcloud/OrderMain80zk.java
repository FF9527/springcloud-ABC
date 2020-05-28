package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:wuqi
 * @date:2020/4/28
 * @description:com.study.springcloud
 * @version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain80zk {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80zk.class,args);
    }
}
