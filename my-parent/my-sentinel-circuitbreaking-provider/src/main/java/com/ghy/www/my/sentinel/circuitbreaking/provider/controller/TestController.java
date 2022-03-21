package com.ghy.www.my.sentinel.circuitbreaking.provider.controller;

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
    public ResponseBox<String> test1(HttpServletRequest request, HttpServletResponse response, boolean isUseCircuitBreaking) {
        System.out.println("get test1 run portValue=" + portValue);
        try {
            if (isUseCircuitBreaking == true) {
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test2")
    public ResponseBox<String> test2(HttpServletRequest request, HttpServletResponse response, int id, boolean isUseCircuitBreaking) throws Exception {
        if (isUseCircuitBreaking == true) {
            if (id <= 16) {
                throw new Exception("test2出现了异常！");
            }
        }
        System.out.println("get test2 run portValue=" + portValue+" id="+id);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test2 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test3")
    public ResponseBox<String> test3(HttpServletRequest request, HttpServletResponse response, int id, boolean isUseCircuitBreaking) throws Exception {
        if (isUseCircuitBreaking == true) {
            if (id <= 8) {
                throw new Exception("test3出现了异常！");
            }
        }
        System.out.println("get test3 run portValue=" + portValue+" id="+id);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test3 value");
        box.setMessage("操作成功");
        return box;
    }
}
