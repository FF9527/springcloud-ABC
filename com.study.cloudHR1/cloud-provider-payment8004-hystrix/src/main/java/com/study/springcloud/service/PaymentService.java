package com.study.springcloud.service;

import com.study.cloud.entities.Payment;

/**
 * @author:wuqi
 * @date:2020/5/16
 * @description:com.study.springcloud.service
 * @version:1.0
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);
}