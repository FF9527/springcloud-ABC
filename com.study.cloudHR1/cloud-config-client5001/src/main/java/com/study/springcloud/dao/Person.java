package com.study.springcloud.dao;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:wuqi
 * @date:2020/6/2
 * @description:com.study.springcloud.dao
 * @version:1.0
 */
@Component
@ConfigurationProperties(prefix = "config.test.person")
@Data
public class Person {
    private String name;
    private Long id;
    private Integer age;
    private Integer sex;
}
