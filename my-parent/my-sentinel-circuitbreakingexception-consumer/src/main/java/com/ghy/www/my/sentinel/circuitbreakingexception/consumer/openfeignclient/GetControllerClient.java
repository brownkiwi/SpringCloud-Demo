package com.ghy.www.my.sentinel.circuitbreakingexception.consumer.openfeignclient;

import com.ghy.www.dto.ResponseBox;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "my-sentinel-circuitbreakingexception-provider-8085")
public interface GetControllerClient {
    @GetMapping(value = "test1")
    public ResponseBox<String> test1(@RequestParam String username, @RequestParam HttpServletRequest request,
                                     @RequestParam HttpServletResponse response);

    @GetMapping(value = "test2")
    public ResponseBox<String> test2(@RequestParam String username, @RequestParam HttpServletRequest request,
                                     @RequestParam HttpServletResponse response);

    @GetMapping(value = "test3")
    public ResponseBox<String> test3(@RequestParam HttpServletRequest request,
                                     @RequestParam HttpServletResponse response, @RequestParam boolean isUseCircuitBreaking);
}

