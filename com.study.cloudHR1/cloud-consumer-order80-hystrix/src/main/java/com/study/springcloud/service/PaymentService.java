package com.study.springcloud.service;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author:wuqi
 * @date:2020/5/16
 * @description:com.study.springcloud.service
 * @version:1.0
 */
@FeignClient(value = "ClOUD-PAYMENT-SERVICE",fallback = PaymentServiceMock.class)
public interface PaymentService {

    @PutMapping(value = "/payment/create")
    CommonResult create(Payment payment);

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/get/timeout")
    CommonResult timeout();

    @GetMapping(value = "/payment/get/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id);

    @GetMapping(value = "/payment/get/hystrix/timeout/{id}")
    public String paymentInfo_Out(@PathVariable("id")Integer id);

}
