package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author:wuqi
 * @date:2020/6/2
 * @description:com.study.springcloud
 * @version:1.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerMain6001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain6001.class,args);
    }
}
