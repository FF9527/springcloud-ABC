package com.study.loadbalanced.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:wuqi
 * @date:2020/4/30
 * @description:com.study.loadbalanced.rule
 * @version:1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getMyRule(){
        return new RandomRule();
    }
}
