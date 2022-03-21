package com.ghy.www.my.nacos.provider.standalone.cluster.controller;

import com.ghy.www.dto.ResponseBox;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ReceiveHead {
    @RequestMapping("receive")
    public ResponseBox<String> receive(HttpServletRequest request, HttpServletResponse response) {
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData(request.getHeader("xxxx"));
        box.setMessage("操作成功");
        return box;
    }
}
