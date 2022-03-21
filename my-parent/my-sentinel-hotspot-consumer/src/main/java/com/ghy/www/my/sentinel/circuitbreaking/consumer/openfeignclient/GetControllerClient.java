package com.ghy.www.my.sentinel.circuitbreaking.consumer.openfeignclient;

import com.ghy.www.dto.ResponseBox;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "my-sentinel-hotspot-provider-8085")
public interface GetControllerClient {
    @GetMapping(value = "test1_1")
    public ResponseBox<String> test1_1(@RequestParam int id, @RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);

    @GetMapping(value = "test1_2")
    public ResponseBox<String> test1_2(@RequestParam int id, @RequestParam String username, @RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);

    @GetMapping(value = "test1_3")
    public ResponseBox<String> test1_3(@RequestParam int id, @RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);
}
