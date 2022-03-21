package com.ghy.www.my.sentinel.flowcontrolexception.provider.sentinelhandler;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ghy.www.dto.ResponseBox;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SentinelHandler {
    //限流处理
    public static ResponseBox<String> handleFlowControl(String username, HttpServletRequest request, HttpServletResponse response, BlockException blockException) {
        System.out.println("发生控流，进入了SentinelHandler.handleFlowControl方法，异常类名：" + blockException.getClass().getName());
        ResponseBox box = new ResponseBox();
        box.setResponseCode(500);
        box.setMessage("发生控流，进入了SentinelHandler.handleFlowControl方法，异常类名：" + blockException.getClass().getName());
        return box;
    }
}
