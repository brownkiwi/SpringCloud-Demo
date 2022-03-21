package com.ghy.www.my.nacos.config.refreshable.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RefreshScope
public class GetNewConfigController {
    @Value("${userinfo.username}")
    private String username;

    @Value("${userinfo.password}")
    private String password;

    @RequestMapping("getNewConfig")
    public String getNewConfig(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        return "返回值";
    }
}
