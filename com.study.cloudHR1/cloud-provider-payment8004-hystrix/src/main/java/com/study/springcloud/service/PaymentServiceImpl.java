package com.study.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.study.cloud.entities.Payment;
import com.study.springcloud.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author:wuqi
 * @date:2020/4/28
 * @description:com.study.springcloud.service
 * @version:1.0
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:"+Thread.currentThread().getName()+", paymentInfo_OK, id:"+id+"\t ^_^";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
        @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value="3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+", paymentInfo_TimeOut, id:"+id+"\t o(╥﹏╥)o";
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+",8004系统繁忙或运行异常，请稍后再试, id:"+id+"\t o(╥﹏╥)o";
    }
}
