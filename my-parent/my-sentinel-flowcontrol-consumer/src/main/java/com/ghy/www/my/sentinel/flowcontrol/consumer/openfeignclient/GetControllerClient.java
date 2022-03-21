package com.ghy.www.my.sentinel.flowcontrol.consumer.openfeignclient;

import com.ghy.www.dto.ResponseBox;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "my-sentinel-flowcontrol-provider-8085")
public interface GetControllerClient {
    @GetMapping(value = "test1")
    public ResponseBox<String> test1(@RequestParam HttpServletRequest request,
                                     @RequestParam HttpServletResponse response);

    @GetMapping(value = "test2")
    public ResponseBox<String> test2(@RequestParam HttpServletRequest request,
                                     @RequestParam HttpServletResponse response);

    @GetMapping(value = "test3")
    public ResponseBox<String> test3(@RequestParam HttpServletRequest request,
                                     @RequestParam HttpServletResponse response);

    @GetMapping(value = "test3_1")
    public ResponseBox<String> test3_1(@RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);

    @GetMapping(value = "test3_2")
    public ResponseBox<String> test3_2(@RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);

    @GetMapping(value = "test4_1")
    public ResponseBox<String> test4_1(@RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);

    @GetMapping(value = "test4_2")
    public ResponseBox<String> test4_2(@RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);

    @GetMapping(value = "test5_1")
    public ResponseBox<String> test5_1(@RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);

    @GetMapping(value = "test5_2")
    public ResponseBox<String> test5_2(@RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);
    @GetMapping(value = "test6")
    public ResponseBox<String> test6(@RequestParam HttpServletRequest request,
                                       @RequestParam HttpServletResponse response);
}
