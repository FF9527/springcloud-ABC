package com.study.springcloud.controller;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:wuqi
 * @date:2020/4/28
 * @description:com.study.springcloud.controller
 * @version:1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
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


}
