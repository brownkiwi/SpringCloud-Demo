package com.ghy.www.my.nacos.namespace.provider.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@RestController
public class TestController {

    @Value("${server.port}")
    private int portValue;

    @GetMapping(value = "Test1")
    public ResponseBox<UserinfoDTO2> Test1(UserinfoDTO2 userinfoDTO2Param) throws UnsupportedEncodingException {
        String id = userinfoDTO2Param.getId();
        String username = new String(Base64.getUrlDecoder().decode(userinfoDTO2Param.getUsername()));
        String password = new String(Base64.getUrlDecoder().decode(userinfoDTO2Param.getPassword()));
        String age = userinfoDTO2Param.getAge();
        String insertdate = userinfoDTO2Param.getInsertdate();

        System.out.println("get test5 run portValue=" + portValue);
        System.out.println("id=" + id);
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        System.out.println("age=" + age);
        System.out.println("insertdate=" + insertdate);

        UserinfoDTO2 returnUserinfoDTO2 = new UserinfoDTO2();
        returnUserinfoDTO2.setId("100");
        returnUserinfoDTO2.setUsername("中国");
        returnUserinfoDTO2.setPassword("中国人");
        returnUserinfoDTO2.setAge("1");
        returnUserinfoDTO2.setInsertdate("2000-01-01");

        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData(returnUserinfoDTO2);
        box.setMessage("操作成功");
        return box;
    }
}

