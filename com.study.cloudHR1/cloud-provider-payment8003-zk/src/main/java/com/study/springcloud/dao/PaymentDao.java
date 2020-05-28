package com.study.springcloud.dao;

import com.study.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author:wuqi
 * @date:2020/4/28
 * @description:com.study.springcloud.dao
 * @version:1.0
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
