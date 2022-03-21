package com.ghy.www.my.sentinel.circuitbreakingexception.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ghy.www.dto.ResponseBox;
import com.ghy.www.my.sentinel.circuitbreakingexception.provider.sentinelhandler.SentinelHandler1;
import com.ghy.www.my.sentinel.circuitbreakingexception.provider.sentinelhandler.SentinelHandler2;
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
    @SentinelResource(value = "test1SentinelResource", fallback = "test1FallBackMethod")
    public ResponseBox<String> test1(String username, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("get test1 run portValue=" + portValue + " username=" + username);
        int i = 0;
        if (i == 0) {
            throw new Exception("我是异常信息！");
        }
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1 value");
        box.setMessage("操作成功");
        return box;
    }

    public ResponseBox<String> test1FallBackMethod(String username, HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
        System.out.println("发生控流，进入了test1FallBackMethod方法，异常类名：" + throwable.getClass().getName() + " BlockException.isBlockException(Throwable t)=" + BlockException.isBlockException(throwable));
        ResponseBox box = new ResponseBox();
        box.setResponseCode(500);
        box.setData("test1 value");
        box.setMessage("发生控流，进入了test1FallBackMethod方法，异常类名：" + throwable.getClass().getName() + " BlockException.isBlockException(Throwable t)=" + BlockException.isBlockException(throwable));
        return box;
    }
    @GetMapping(value = "test2")
    @SentinelResource(value = "test2SentinelResource",
            fallback = "handleError", //异常调用方法
            fallbackClass = SentinelHandler1.class //异常处理类
    )
    public ResponseBox<String> test2(String username, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("get test2 run portValue=" + portValue + " username=" + username);
        int i = 0;
        if (i == 0) {
            throw new Exception("我是异常信息！");
        }
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test2 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test3")
    @SentinelResource(value = "test3SentinelResource",
            fallback = "handleError", //异常调用方法
            fallbackClass = SentinelHandler2.class //异常处理类
    )
    public ResponseBox<String> test3(HttpServletRequest request, HttpServletResponse response, boolean isUseCircuitBreaking) {
        System.out.println("get test3 run portValue=" + portValue);
        try {
            if (isUseCircuitBreaking == true) {
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test3 value");
        box.setMessage("操作成功");
        return box;
    }

}

