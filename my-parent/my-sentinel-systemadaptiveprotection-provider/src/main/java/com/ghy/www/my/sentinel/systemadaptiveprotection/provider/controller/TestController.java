package com.ghy.www.my.sentinel.systemadaptiveprotection.provider.controller;

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

    @GetMapping(value = "test1")
    public ResponseBox<String> test1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test1 run portValue=" + portValue);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1 value");
        box.setMessage("操作成功");
        return box;
    }
}
