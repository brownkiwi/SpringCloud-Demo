package com.ghy.www.my.sentinel.flowcontrol.provider.controller;

import com.ghy.www.dto.ResponseBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class InitController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "initPath")
    public void initTest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了initPath");
        restTemplate.getForObject("http://localhost:8085/test1", ResponseBox.class);
        restTemplate.getForObject("http://localhost:8085/test2", ResponseBox.class);
        restTemplate.getForObject("http://localhost:8085/test3", ResponseBox.class);
        restTemplate.getForObject("http://localhost:8085/test4_1", ResponseBox.class);
        restTemplate.getForObject("http://localhost:8085/test4_2", ResponseBox.class);
    }
}
