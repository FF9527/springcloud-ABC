package com.study.springcloud.service;


import com.study.cloud.entities.Payment;

/**
 * @author:wuqi
 * @date:2020/4/28
 * @description:com.study.springcloud.service
 * @version:1.0
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
