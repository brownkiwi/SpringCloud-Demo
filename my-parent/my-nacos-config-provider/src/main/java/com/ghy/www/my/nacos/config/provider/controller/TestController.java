package com.ghy.www.my.nacos.config.provider.controller;

import com.ghy.www.dto.ResponseBox;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("get")
public class TestController {
    @GetMapping(value = "test1")
    public ResponseBox<String> test1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test1 run");
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1 value");
        box.setMessage("操作成功");
        return box;
    }
}
