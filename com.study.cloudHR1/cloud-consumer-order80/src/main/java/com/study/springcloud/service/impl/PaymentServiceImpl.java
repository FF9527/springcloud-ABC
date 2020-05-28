package com.study.springcloud.service.impl;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author:wuqi
 * @date:2020/4/30
 * @description:com.study.springcloud.service.impl
 * @version:1.0
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private final static String PAYMENTSERVER = "http://CLOUD-PAYMENT-SERVICE";

    @Override
    public CommonResult<Integer> create(Payment payment) {
        CommonResult<Integer> result = restTemplate.postForObject(PAYMENTSERVER+"/payment/create",payment,CommonResult.class);
        return result;
    }

    @Override
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        List<String> services = discoveryClient.getServices();
        if (services != null && services.size() != 0){
            for (String service : services) {
                List<ServiceInstance> instances = discoveryClient.getInstances(service);
                if (instances != null && instances.size() != 0) {
                    for (ServiceInstance instance : instances) {
                        StringBuffer sb = new StringBuffer();
                        //主机名
                        sb.append("host = "+instance.getHost());
                        //client的instanceId，格式是host：applicationName：serverPort
                        sb.append(", instanceId = "+instance.getInstanceId());
                        sb.append(", scheme = "+instance.getScheme());
                        //applicationName的大写
                        sb.append(", serviceId = "+instance.getServiceId());
                        sb.append(", metadata = "+instance.getMetadata());
                        //client的端口号
                        sb.append(", port = "+instance.getPort());
                        //client的urI:格式：http://host:port
                        sb.append(", urI = "+instance.getUri());
                        log.info(sb.toString());
                    }
                }
            }
        }
        CommonResult<Payment> result = restTemplate.getForObject(PAYMENTSERVER+"/payment/get/"+id,CommonResult.class);
        log.info("******查询结果：" + result);
        return result;

    }
}
