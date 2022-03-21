package com.ghy.www.my.sentinel.originauthoritycontrol.consumer.requestinterceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyRequestInterceptor implements RequestInterceptor {
    public void apply(RequestTemplate requestTemplate) {
        //统一设置请求头source属性值
        requestTemplate.header("source", "my-sentinel-originauthoritycontrol-consumer-8091");
    }
}
