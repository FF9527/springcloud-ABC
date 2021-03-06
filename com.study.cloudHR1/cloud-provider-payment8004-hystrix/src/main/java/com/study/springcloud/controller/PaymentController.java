package com.study.springcloud.controller;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author:wuqi
 * @date:2020/5/16
 * @description:com.study.springcloud.controller
 * @version:1.0
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if (result > 0) {
            return new CommonResult<>(200, "success", result);
        }
        return new CommonResult<>(444, "failed", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果：serverPort " + serverPort + " ," + payment);
        if (payment != null) {
            return new CommonResult<>(200, "success, serverPort:" + serverPort, payment);
        }
        return new CommonResult<>(444, "failed, serverPort:" + serverPort, null);

    }

    @GetMapping(value = "/payment/get/timeout")
    public CommonResult<Payment> timeout() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<>();

    }

    @GetMapping(value = "/payment/get/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*****result:"+result);
        return result;
    }

    @GetMapping(value = "/payment/get/hystrix/timeout/{id}")
    public String paymentInfo_Out(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result:"+result);
        return result;
    }
}
