package com.study.springcloud.controller;

import com.study.springcloud.dao.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:wuqi
 * @date:2020/6/2
 * @description:com.study.springcloud.controller
 * @version:1.0
 */
@RestController
@RequestMapping(value = "config/client")
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Resource
    private Person person;

    @GetMapping(value = "/get/person")
    public Person getPerson(){
        return person;
    }
}
