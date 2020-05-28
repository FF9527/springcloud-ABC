package com.study.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:wuqi
 * @date:2020/5/16
 * @description:com.study.springcloud.controller
 * @version:1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultHandler")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        CommonResult<Integer> result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        return result;
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult<Payment> result = paymentService.getPaymentById(id);
        log.info("******查询结果：" + result);
        return result;

    }

    @GetMapping(value = "/payment/get/timeout")
    public CommonResult<Payment> timeout() {
        CommonResult<Payment> result = paymentService.timeout();
        log.info("******查询结果：" + result);
        return result;

    }

    @GetMapping(value = "/payment/get/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/payment/get/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_OutHandler",commandProperties = {
            //@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value = "2000"),//服务降级超时时间
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value = "true"),//是否开启断路器
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value = "10"),//请求次数
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value = "10000"),//时间窗口
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "60"),//失败率阈值，达到后开启熔断
            //10s内，请求次数>10次,失败请求*0.6时，开启熔断状态,默认配置在HystrixCommandProperties.class中
    })
    public String paymentInfo_Out(@PathVariable("id")Integer id){
        return paymentService.paymentInfo_Out(id);
    }

    public String paymentInfo_OutHandler(@PathVariable("id")Integer id){
        return "我是80，支付系统繁忙，即将跳转至账单，确认支付结果。";
    }
    public String defaultHandler(){
        return "我是80，服务异常请稍后再试";
    }

}
