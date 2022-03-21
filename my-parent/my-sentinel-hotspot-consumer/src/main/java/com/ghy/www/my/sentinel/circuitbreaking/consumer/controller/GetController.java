package com.ghy.www.my.sentinel.circuitbreaking.consumer.controller;

import com.ghy.www.my.sentinel.circuitbreaking.consumer.openfeignclient.GetControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GetController {
    @Autowired
    private GetControllerClient getControllerClient;

    @RequestMapping("test1_1")
    public void test1_1(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println(getControllerClient.test1_1(1, request, response));
            System.out.println(getControllerClient.test1_1(1, request, response));
            System.out.println(getControllerClient.test1_1(1, request, response));
            System.out.println(getControllerClient.test1_1(1, request, response));
            System.out.println(getControllerClient.test1_1(1, request, response));
            System.out.println(getControllerClient.test1_1(1, request, response));
            System.out.println(getControllerClient.test1_1(1, request, response));
            System.out.println(getControllerClient.test1_1(1, request, response));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(getControllerClient.test1_1(1, request, response));
            System.out.println(getControllerClient.test1_1(1, request, response));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getControllerClient.test1_1(1, request, response));
        System.out.println(getControllerClient.test1_1(1, request, response));
    }

    @RequestMapping("test1_2")
    public void test1_2(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
            System.out.println(getControllerClient.test1_2(1, "a", request, response));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getControllerClient.test1_2(1, "a", request, response));
        System.out.println(getControllerClient.test1_2(1, "a", request, response));
    }


    @RequestMapping("test1_3")
    public void test1_3(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println(getControllerClient.test1_3(1, request, response));
            System.out.println(getControllerClient.test1_3(1, request, response));
            System.out.println(getControllerClient.test1_3(1, request, response));
            System.out.println(getControllerClient.test1_3(1, request, response));
            System.out.println(getControllerClient.test1_3(1, request, response));
            System.out.println(getControllerClient.test1_3(1, request, response));
            System.out.println(getControllerClient.test1_3(1, request, response));
            System.out.println(getControllerClient.test1_3(1, request, response));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            System.out.println(getControllerClient.test1_3(2, request, response));
            System.out.println(getControllerClient.test1_3(2, request, response));
            System.out.println(getControllerClient.test1_3(2, request, response));
            System.out.println(getControllerClient.test1_3(2, request, response));
            System.out.println(getControllerClient.test1_3(2, request, response));
            System.out.println(getControllerClient.test1_3(2, request, response));
            System.out.println(getControllerClient.test1_3(2, request, response));
            System.out.println(getControllerClient.test1_3(2, request, response));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            System.out.println(getControllerClient.test1_3(3, request, response));
            System.out.println(getControllerClient.test1_3(3, request, response));
            System.out.println(getControllerClient.test1_3(3, request, response));
            System.out.println(getControllerClient.test1_3(3, request, response));
            System.out.println(getControllerClient.test1_3(3, request, response));
            System.out.println(getControllerClient.test1_3(3, request, response));
            System.out.println(getControllerClient.test1_3(3, request, response));
            System.out.println(getControllerClient.test1_3(3, request, response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

