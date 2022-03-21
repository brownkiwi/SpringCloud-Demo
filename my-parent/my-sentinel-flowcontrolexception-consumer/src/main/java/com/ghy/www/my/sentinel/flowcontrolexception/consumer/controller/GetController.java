package com.ghy.www.my.sentinel.flowcontrolexception.consumer.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.my.sentinel.flowcontrolexception.consumer.openfeignclient.GetControllerClient;
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
    public ResponseBox<String> test1(String username, HttpServletRequest request, HttpServletResponse response) {
        return getControllerClient.test1("账号", request, response);
    }

    @RequestMapping("test2")
    public ResponseBox<String> test2(String username, HttpServletRequest request, HttpServletResponse response) {
        return getControllerClient.test2("账号", request, response);
    }
}
