package com.study.springcloud.service;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:wuqi
 * @date:2020/4/30
 * @description:com.study.springcloud.service
 * @version:1.0
 */
public interface PaymentService {

    CommonResult create(Payment payment);

    CommonResult getPaymentById(@PathVariable("id")Long id);
}
