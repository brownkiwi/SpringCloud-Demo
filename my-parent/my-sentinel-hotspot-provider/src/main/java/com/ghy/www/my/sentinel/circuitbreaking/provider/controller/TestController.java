package com.ghy.www.my.sentinel.circuitbreaking.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ghy.www.dto.ResponseBox;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {
    @Value("${server.port}")
    private int portValue;

    @GetMapping(value = "test1_1")
    @SentinelResource("test1_1SentinelResource")
    public ResponseBox<String> test1_1(int id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("get test1_1 run portValue=" + portValue + " id=" + id);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1_1 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test1_2")
    @SentinelResource("test1_2SentinelResource")
    public ResponseBox<String> test1_2(int id, String username, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("get test1_2 run portValue=" + portValue + " id=" + id + " username=" + username);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1_2 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test1_3")
    @SentinelResource("test1_3SentinelResource")
    public ResponseBox<String> test1_3(int id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("get test1_3 run portValue=" + portValue + " id=" + id);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1_3 value");
        box.setMessage("操作成功");
        return box;
    }

}
