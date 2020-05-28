package com.study.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:wuqi
 * @date:2020/5/26
 * @description:com.study.springcloud.config
 * @version:1.0
 */
@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_gateway",r->r.path("/hystrix").uri(
        "http://localhost:8004/"));
        return routes.build();
    }

}

