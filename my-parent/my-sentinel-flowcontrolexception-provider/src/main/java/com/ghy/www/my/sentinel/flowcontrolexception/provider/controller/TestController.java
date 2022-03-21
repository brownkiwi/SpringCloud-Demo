package com.ghy.www.my.sentinel.flowcontrolexception.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ghy.www.dto.ResponseBox;
import com.ghy.www.my.sentinel.flowcontrolexception.provider.sentinelhandler.SentinelHandler;
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
    @SentinelResource(value = "test1SentinelResource", blockHandler = "test1FallBackMethod")
    public ResponseBox<String> test1(String username, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test1 run portValue=" + portValue + " username=" + username);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1 value");
        box.setMessage("操作成功");
        return box;
    }

    public ResponseBox<String> test1FallBackMethod(String username, HttpServletRequest request, HttpServletResponse response, BlockException blockException) {
        System.out.println("发生控流，进入了test1FallBackMethod方法，异常类名：" + blockException.getClass().getName());
        ResponseBox box = new ResponseBox();
        box.setResponseCode(500);
        box.setData("test1 value");
        box.setMessage("发生控流，进入了test1FallBackMethod方法，异常类名：" + blockException.getClass().getName());
        return box;
    }

    ////////////////////////////////
    @GetMapping(value = "test2")
    @SentinelResource(value = "test2SentinelResource", blockHandler = "handleFlowControl", //限流处理方法
            blockHandlerClass = SentinelHandler.class//限流处理类
    )
    public ResponseBox<String> test2(String username, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test2 run portValue=" + portValue + " username=" + username);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test2 value");
        box.setMessage("操作成功");
        return box;
    }
}

