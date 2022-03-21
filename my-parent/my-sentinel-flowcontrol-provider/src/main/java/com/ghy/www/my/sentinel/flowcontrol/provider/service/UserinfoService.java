package com.ghy.www.my.sentinel.flowcontrol.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class UserinfoService {
    @SentinelResource("userinfoSeviceMethod")
    public void userinfoSeviceMethod() {
        System.out.println("userinfoSeviceMethod run !");
    }
}
