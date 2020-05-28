package com.study.springcloud.service;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author:wuqi
 * @date:2020/4/30
 * @description:com.study.springcloud.service
 * @version:1.0
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @PostMapping(value = "/payment/create")
    CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/get/timeout")
    CommonResult timeout();


}
