package com.ghy.www.my.sentinel.circuitbreakingexception.provider.sentinelhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ghy.www.dto.ResponseBox;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SentinelHandler2 {
    //异常处理
    public static ResponseBox<String> handleError(HttpServletRequest request, HttpServletResponse response, boolean isUseCircuitBreaking, Throwable throwable) {
        System.out.println("发生控流，进入了SentinelHandler2.handleError方法，异常类名：" + throwable.getClass().getName() + " BlockException.isBlockException(Throwable t)=" + BlockException.isBlockException(throwable));
        ResponseBox box = new ResponseBox();
        box.setResponseCode(500);
        box.setMessage("发生控流，进入了SentinelHandler2.handleError方法，异常类名：" + throwable.getClass().getName() + " BlockException.isBlockException(Throwable t)=" + BlockException.isBlockException(throwable));
        return box;
    }
}
