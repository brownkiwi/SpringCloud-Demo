package com.ghy.www.my.sentinel.flowcontrol.provider.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.my.sentinel.flowcontrol.provider.service.UserinfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {
    private UserinfoService userinfoService=new UserinfoService();

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

    @GetMapping(value = "test2")
    public ResponseBox<String> test2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test2 run portValue=" + portValue);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test2 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test3")
    public ResponseBox<String> test3(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test3 run portValue=" + portValue +System.currentTimeMillis());
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test3 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test4_1")
    public ResponseBox<String> test4_1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test4_1 run portValue=" + portValue);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test4_1 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test4_2")
    public ResponseBox<String> test4_2(HttpServletRequest request, HttpServletResponse response) {
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test4_2 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test5_1")
    public ResponseBox<String> test5_1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test5_1 run portValue=" + portValue);
        userinfoService.userinfoSeviceMethod();
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test4_1 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test5_2")
    public ResponseBox<String> test5_2(HttpServletRequest request, HttpServletResponse response) {
        ResponseBox box = new ResponseBox();
        userinfoService.userinfoSeviceMethod();
        box.setResponseCode(200);
        box.setData("test5_2 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test6")
    public ResponseBox<String> test6(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test6 run portValue=" + portValue);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test6 value");
        box.setMessage("操作成功");
        return box;
    }

}

