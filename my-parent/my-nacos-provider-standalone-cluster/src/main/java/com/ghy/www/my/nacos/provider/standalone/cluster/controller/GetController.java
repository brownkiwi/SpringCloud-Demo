package com.ghy.www.my.nacos.provider.standalone.cluster.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@RestController
@RequestMapping("get")
public class GetController {

    @Value("${server.port}")
    private int portValue;

    @GetMapping(value = "test1")
    public ResponseBox<String> test1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get test1 run portValue=" + portValue);
        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test1 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test2")
    public ResponseBox<String> test2(String id, String username, String password, String age, String insertdate) throws UnsupportedEncodingException {
        username = new String(Base64.getUrlDecoder().decode(username));
        password = new String(Base64.getUrlDecoder().decode(password));
        System.out.println("get test2 run portValue=" + portValue);
        System.out.println("id=" + id);
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        System.out.println("age=" + age);
        System.out.println("insertdate=" + insertdate);

        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test2 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test3/id/{id}/username/{username}/password/{password}/age/{age}/insertdate/{insertdate}")
    public ResponseBox<String> test3(@PathVariable String id, @PathVariable String username, @PathVariable String password, @PathVariable String age, @PathVariable String insertdate) throws UnsupportedEncodingException {
        username = new String(Base64.getUrlDecoder().decode(username));
        password = new String(Base64.getUrlDecoder().decode(password));
        System.out.println("get test3 run portValue=" + portValue);
        System.out.println("id=" + id);
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        System.out.println("age=" + age);
        System.out.println("insertdate=" + insertdate);

        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData("test3 value");
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test4")
    public ResponseBox<UserinfoDTO2> test4(String id, String username, String password, String age, String insertdate) throws UnsupportedEncodingException {
        username = new String(Base64.getUrlDecoder().decode(username));
        password = new String(Base64.getUrlDecoder().decode(password));
        System.out.println("get test4 run portValue=" + portValue);
        System.out.println("id=" + id);
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        System.out.println("age=" + age);
        System.out.println("insertdate=" + insertdate);

        UserinfoDTO2 userinfoDTO2 = new UserinfoDTO2();
        userinfoDTO2.setId("1");
        userinfoDTO2.setUsername("中国");
        userinfoDTO2.setPassword("中国人");
        userinfoDTO2.setAge("1");
        userinfoDTO2.setInsertdate("2000-01-01");

        ResponseBox box = new ResponseBox();
        box.setResponseCode(200);
        box.setData(userinfoDTO2);
        box.setMessage("操作成功");
        return box;
    }

    @GetMapping(value = "test5")
    public ResponseBox<UserinfoDTO2> test5(UserinfoDTO2 userinfoDTO2Param) throws UnsupportedEncodingException {
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

    @GetMapping(value = "test6")
    public ResponseBox<UserinfoDTO2> test6(@RequestBody UserinfoDTO2 userinfoDTO2Param) throws UnsupportedEncodingException {
        String id = userinfoDTO2Param.getId();
        String username = new String(Base64.getUrlDecoder().decode(userinfoDTO2Param.getUsername()));
        String password = new String(Base64.getUrlDecoder().decode(userinfoDTO2Param.getPassword()));
        String age = userinfoDTO2Param.getAge();
        String insertdate = userinfoDTO2Param.getInsertdate();

        System.out.println("delete test6 run portValue=" + portValue);
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