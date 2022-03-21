package com.ghy.www.my.sentinel.datasourceextensionpull.consumer.controller;

import com.ghy.www.my.sentinel.datasourceextensionpull.consumer.openfeignclient.GetControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GetController {
    @Autowired
    private GetControllerClient getControllerClient;

    @RequestMapping("test1")
    public void test1(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 10; i++) {
            getControllerClient.test1(request, response);
            System.out.println("test1消费了：" + (i) + "次");
        }
    }
}