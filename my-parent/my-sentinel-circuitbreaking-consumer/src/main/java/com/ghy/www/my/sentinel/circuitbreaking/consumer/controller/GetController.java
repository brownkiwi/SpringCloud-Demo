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
    public void test1(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 20; i++) {
            Thread newThread = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("执行了test1_1 返回值：" + getControllerClient.test1(request, response, false));
                    } catch (Exception e) {
                        System.out.println("出现异常:" + e.getMessage());
                    }
                }
            };
            newThread.start();
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }

    @RequestMapping("test1_2")
    public void test1_2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 20; i++) {
            Thread newThread = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("执行了test1_2 返回值：" + getControllerClient.test1(request, response, true));
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

        for (int i = 1; i <= 3; i++) {
            Thread newThread = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("6s后的打印test1_2 返回值：" + getControllerClient.test1(request, response, true));
                    } catch (Exception e) {
                        System.out.println("出现异常:" + e.getMessage());
                    }
                }
            };
            newThread.start();
        }
    }

    class MyThread2 extends Thread {
        private HttpServletRequest request;
        private HttpServletResponse response;
        private GetControllerClient getControllerClient;
        private int i;
        private boolean isUseCircuitBreaking;

        public MyThread2(HttpServletRequest request, HttpServletResponse response, GetControllerClient getControllerClient, int i, boolean isUseCircuitBreaking) {
            this.request = request;
            this.response = response;
            this.getControllerClient = getControllerClient;
            this.i = i;
            this.isUseCircuitBreaking = isUseCircuitBreaking;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行了test2 返回值：" + getControllerClient.test2(request, response, i, isUseCircuitBreaking));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @RequestMapping("test2_1")
    public void test2_1(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 50; i++) {
            MyThread2 newThread = new MyThread2(request, response, getControllerClient, 100, true);
            newThread.start();
        }
    }

    @RequestMapping("test2_2")
    public void test2_2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 20; i++) {
            MyThread2 newThread = new MyThread2(request, response, getControllerClient, i, true);
            newThread.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------");
        for (int i = 1; i <= 2; i++) {
            MyThread2 newThread = new MyThread2(request, response, getControllerClient, 100, true);
            newThread.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------");
        for (int i = 1; i <= 2; i++) {
            MyThread2 newThread = new MyThread2(request, response, getControllerClient, 100, true);
            newThread.start();
        }
    }


    @RequestMapping("test2_3")
    public void test2_3(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 50; i++) {
            MyThread2 newThread = new MyThread2(request, response, getControllerClient, i, false);
            newThread.start();
        }
    }

    class MyThread3 extends Thread {
        private HttpServletRequest request;
        private HttpServletResponse response;
        private GetControllerClient getControllerClient;
        private int i;
        private boolean isUseCircuitBreaking;

        public MyThread3(HttpServletRequest request, HttpServletResponse response, GetControllerClient getControllerClient, int i, boolean isUseCircuitBreaking) {
            this.request = request;
            this.response = response;
            this.getControllerClient = getControllerClient;
            this.i = i;
            this.isUseCircuitBreaking = isUseCircuitBreaking;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行了test3 返回值：" + getControllerClient.test3(request, response, i, isUseCircuitBreaking));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @RequestMapping("test3_1")
    public void test3_1(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 50; i++) {
            MyThread3 newThread = new MyThread3(request, response, getControllerClient, i, false);
            newThread.start();
        }
    }

    @RequestMapping("test3_2")
    public void test3_2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 11; i++) {
            MyThread3 newThread = new MyThread3(request, response, getControllerClient, i, true);
            newThread.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------");
        for (int i = 1; i <= 2; i++) {
            MyThread3 newThread = new MyThread3(request, response, getControllerClient, 100, true);
            newThread.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------");
        for (int i = 1; i <= 2; i++) {
            MyThread3 newThread = new MyThread3(request, response, getControllerClient, 100, true);
            newThread.start();
        }
    }
}


