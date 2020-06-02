package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author:wuqi
 * @date:2020/6/2
 * @description:com.study.springcloud
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain5002 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain5002.class,args);
    }
}
