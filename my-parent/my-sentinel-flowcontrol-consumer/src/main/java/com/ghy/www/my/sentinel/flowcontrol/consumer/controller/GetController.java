package com.ghy.www.my.sentinel.flowcontrol.consumer.controller;

import com.ghy.www.my.sentinel.flowcontrol.consumer.openfeignclient.GetControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.CountDownLatch;

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

    @RequestMapping("test2")
    public void test2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Thread newThread = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < Integer.MAX_VALUE; j++) {
                        System.out.println("执行了test2");
                        getControllerClient.test2(request, response);
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            newThread.start();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyThread3 extends Thread {
        private HttpServletRequest request;
        private HttpServletResponse response;
        private GetControllerClient getControllerClient;
        private CountDownLatch latch;

        public MyThread3(HttpServletRequest request, HttpServletResponse response, GetControllerClient getControllerClient, CountDownLatch latch) {
            this.request = request;
            this.response = response;
            this.getControllerClient = getControllerClient;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
                System.out.println("test3执行了，返回值： " + getControllerClient.test3(request, response));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("test3")
    public void test3(HttpServletRequest request, HttpServletResponse response) {
        CountDownLatch latch = new CountDownLatch(1);
        MyThread3[] newThreadArray = new MyThread3[5];
        for (int i = 1; i <= 5; i++) {
            newThreadArray[i - 1] = new MyThread3(request, response, getControllerClient, latch);
        }
        for (int i = 1; i <= 5; i++) {
            newThreadArray[i - 1].start();
        }
        try {
            Thread.sleep(5000);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("test4_1")
    public void test4_1(HttpServletRequest request, HttpServletResponse response) {
        getControllerClient.test4_1(request, response);
        System.out.println("test4_1消费了");
    }

    @RequestMapping("test4_2")
    public void test4_2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            try {
                getControllerClient.test4_2(request, response);
            } catch (Exception e) {
            }
        }
    }

    @RequestMapping("test5_1")
    public void test5_1(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 100; i++) {
            getControllerClient.test5_1(request, response);
        }
    }

    @RequestMapping("test5_2")
    public void test5_2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 1; i <= 100; i++) {
            getControllerClient.test5_2(request, response);
        }
    }

    class MyThread6 extends Thread {
        private HttpServletRequest request;
        private HttpServletResponse response;
        private GetControllerClient getControllerClient;
        private CountDownLatch latch;

        public MyThread6(HttpServletRequest request, HttpServletResponse response, GetControllerClient getControllerClient, CountDownLatch latch) {
            this.request = request;
            this.response = response;
            this.getControllerClient = getControllerClient;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
                System.out.println("test6执行了，返回值： " + getControllerClient.test6(request, response));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("test6")
    public void test6(HttpServletRequest request, HttpServletResponse response) {
        CountDownLatch latch = new CountDownLatch(1);
        MyThread6[] newThreadArray = new MyThread6[6];
        for (int i = 1; i <= 6; i++) {
            newThreadArray[i - 1] = new MyThread6(request, response, getControllerClient, latch);
        }
        for (int i = 1; i <= 6; i++) {
            newThreadArray[i - 1].start();
        }
        try {
            Thread.sleep(5000);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

