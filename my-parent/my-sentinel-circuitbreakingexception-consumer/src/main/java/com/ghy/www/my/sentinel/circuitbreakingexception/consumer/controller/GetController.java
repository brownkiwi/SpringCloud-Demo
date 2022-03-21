package com.ghy.www.my.sentinel.circuitbreakingexception.consumer.controller;

import com.ghy.www.my.sentinel.circuitbreakingexception.consumer.openfeignclient.GetControllerClient;
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
    public String test1(String username, HttpServletRequest request, HttpServletResponse response) {
        return getControllerClient.test1("账号", request, response).getMessage();
    }

    @RequestMapping("test2")
    public String test2(String username, HttpServletRequest request, HttpServletResponse response) {
        return getControllerClient.test2("账号", request, response).getMessage();
    }

    @RequestMapping("test3_1")
    public void test3_1(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 20; i++) {
            Thread newThread = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("执行了test3_1 返回值：" + getControllerClient.test3(request, response, false));
                    } catch (Exception e) {
                        System.out.println("出现异常:" + e.getMessage());
                    }
                }
            };
            newThread.start();
        }
    }

    @RequestMapping("test3_2")
    public void test3_2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 20; i++) {
            Thread newThread = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("执行了test3_2 返回值：" + getControllerClient.test3(request, response, true));
                    } catch (Exception e) {
                        System.out.println("出现异常:" + e.getMessage());
                    }
                }
            };
            newThread.start();
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("");
        try {
            System.out.println("执行了test3_2 返回值：" + getControllerClient.test3(request, response, true));
        } catch (Exception e) {
            System.out.println("出现异常:" + e.getMessage());
        }

    }
}
