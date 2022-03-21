package com.ghy.www.my.nacos.config.refreshable.connectionpool.consumer.openfeignclient;

import com.ghy.www.dto.ResponseBox;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "my-nacos-config-provider-8085")
public interface GetControllerClient {
    @GetMapping(value = "get/test1")
    public ResponseBox<String> test1(@RequestParam HttpServletRequest request, @RequestParam HttpServletResponse response);
}
