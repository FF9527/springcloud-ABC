package com.study.springcloud.controller;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author:wuqi
 * @date:2020/4/28
 * @description:com.study.springcloud.controller
 * @version:1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

//    private final static String PAYMENTSERVER = "http://localhost:8001";
    private final static String PAYMENTSERVER = "http://cloud-payment-service-zk";//使用zookeeper时大小写铭感
//    private final static String PAYMENTSERVER = "http://CLOUD-PAYMENT-SERVICE-ZK";
    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        CommonResult<Integer> result = restTemplate.postForObject(PAYMENTSERVER+"/payment/create",payment,CommonResult.class);
        log.info("******插入结果：" + result);
        return result;
    }

    @GetMapping(value = "/payment/get/{id}")
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
