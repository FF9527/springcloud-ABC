package com.study.springcloud.configurations;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author:wuqi
 * @date:2020/4/28
 * @description:com.study.springcloud
 * @version:1.0
 */
@Configuration
public class Configutations {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
