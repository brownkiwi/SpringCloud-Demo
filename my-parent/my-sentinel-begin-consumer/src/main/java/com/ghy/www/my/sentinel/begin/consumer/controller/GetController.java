package com.ghy.www.my.sentinel.begin.consumer.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.my.sentinel.begin.consumer.openfeignclient.GetControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GetController {
    @Autowired
    private GetControllerClient getControllerClient;

    @RequestMapping("testPath1")
    public String testPath1(HttpServletRequest request, HttpServletResponse response) {
        ResponseBox<String> box = getControllerClient.test1(request, response);
        System.out.println("getData=" + box.getData());
        System.out.println("getMessage=" + box.getMessage());
        System.out.println("getResponseCode=" + box.getResponseCode());
        return box.getData();
    }
}
