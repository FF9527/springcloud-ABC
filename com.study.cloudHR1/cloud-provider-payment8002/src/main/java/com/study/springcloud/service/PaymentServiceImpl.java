package com.study.springcloud.service;

import com.study.cloud.entities.Payment;
import com.study.springcloud.dao.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:wuqi
 * @date:2020/4/28
 * @description:com.study.springcloud.service
 * @version:1.0
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao){
        this.paymentDao = paymentDao;
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
