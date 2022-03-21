package com.ghy.www.my.nacos.openfeign.cluster.consumer.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.my.nacos.openfeign.cluster.consumer.openfeignclient.ClusterControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("cluster")
public class ClusterController {
    @Autowired
    private ClusterControllerClient clusterControllerClient;

    @RequestMapping("test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        ResponseBox<String> box = clusterControllerClient.test1(request, response);
        System.out.println("getData=" + box.getData());
        System.out.println("getMessage=" + box.getMessage());
        System.out.println("getResponseCode=" + box.getResponseCode());
        return "返回值";
    }
}
