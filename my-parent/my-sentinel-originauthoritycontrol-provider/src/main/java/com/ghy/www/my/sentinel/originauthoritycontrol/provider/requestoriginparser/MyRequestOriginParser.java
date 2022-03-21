package com.ghy.www.my.sentinel.originauthoritycontrol.provider.requestoriginparser;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyRequestOriginParser implements RequestOriginParser {
    public String parseOrigin(HttpServletRequest request) {
        System.out.println("执行了MyRequestOriginParser类中的parseOrigin方法");
        //从request header中获取source属性
        String sourceValue = request.getHeader("source");
        System.out.println("sourceValue=" + sourceValue);
        return sourceValue;
    }
}

