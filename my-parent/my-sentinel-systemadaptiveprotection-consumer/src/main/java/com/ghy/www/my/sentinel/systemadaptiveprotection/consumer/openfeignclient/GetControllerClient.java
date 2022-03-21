package com.ghy.www.my.sentinel.systemadaptiveprotection.consumer.openfeignclient;

import com.ghy.www.dto.ResponseBox;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "my-sentinel-systemadaptiveprotection-provider-8085")
public interface GetControllerClient {
    @GetMapping(value = "test1")
    public ResponseBox<String> test1(@RequestParam HttpServletRequest request,
                                     @RequestParam HttpServletResponse response);
}
