package com.study.springcloud.service;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;

/**
 * @author:wuqi
 * @date:2020/5/21
 * @description:com.study.springcloud.service
 * @version:1.0
 */
public class PaymentServiceMock implements PaymentService{

    @Override
    public CommonResult create(Payment payment) {
        return null;
    }

    @Override
    public CommonResult getPaymentById(Long id) {
        return null;
    }

    @Override
    public CommonResult timeout() {
        return null;
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return null;
    }

    @Override
    public String paymentInfo_Out(Integer id) {
        return null;
    }
}
