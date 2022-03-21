package com.ghy.www.my.nacos.openfeign.consumer.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import com.ghy.www.my.nacos.openfeign.consumer.openfeignclient.PostControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@RestController
@RequestMapping("test/post")
public class PostController {

    @Autowired
    private PostControllerClient postControllerClient;

    @RequestMapping("test1")
    public String test1(HttpServletRequest request, HttpServletResponse response) {
        ResponseBox<String> box = postControllerClient.test1(request, response);
        System.out.println("getData=" + box.getData());
        System.out.println("getMessage=" + box.getMessage());
        System.out.println("getResponseCode=" + box.getResponseCode());
        return "返回值";
    }

    @RequestMapping("test2")
    public String test2() throws UnsupportedEncodingException {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        ResponseBox<String> box = postControllerClient.test2(id, username, password, age, insertdate);
        System.out.println("getData=" + box.getData());
        System.out.println("getMessage=" + box.getMessage());
        System.out.println("getResponseCode=" + box.getResponseCode());
        return "返回值";
    }

    @RequestMapping("test3")
    public String test3() throws UnsupportedEncodingException {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        ResponseBox<String> box = postControllerClient.test3(id, username, password, age, insertdate);
        System.out.println("getData=" + box.getData());
        System.out.println("getMessage=" + box.getMessage());
        System.out.println("getResponseCode=" + box.getResponseCode());
        return "返回值";
    }
    @RequestMapping("test4")
    public String test4() throws UnsupportedEncodingException {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        ResponseBox<UserinfoDTO2> box = postControllerClient.test4(id, username, password, age, insertdate);
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate());
        System.out.println("getMessage=" + box.getMessage());
        System.out.println("getResponseCode=" + box.getResponseCode());
        return "返回值";
    }

    // provider:java.lang.NullPointerException: null
    // consumer:Internal Server Error
    @RequestMapping("test5")
    public String test5() throws UnsupportedEncodingException {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        UserinfoDTO2 userinfoDTO2Param = new UserinfoDTO2();
        userinfoDTO2Param.setId(id);
        userinfoDTO2Param.setUsername(username);
        userinfoDTO2Param.setPassword(password);
        userinfoDTO2Param.setAge(age);
        userinfoDTO2Param.setInsertdate(insertdate);

        ResponseBox<UserinfoDTO2> box = postControllerClient.test5(userinfoDTO2Param);
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate());
        System.out.println("getMessage=" + box.getMessage());
        System.out.println("getResponseCode=" + box.getResponseCode());
        return "返回值";
    }

    @RequestMapping("test6")
    public String test6() throws UnsupportedEncodingException {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        UserinfoDTO2 userinfoDTO2Param = new UserinfoDTO2();
        userinfoDTO2Param.setId(id);
        userinfoDTO2Param.setUsername(username);
        userinfoDTO2Param.setPassword(password);
        userinfoDTO2Param.setAge(age);
        userinfoDTO2Param.setInsertdate(insertdate);

        ResponseBox<UserinfoDTO2> box = postControllerClient.test6(userinfoDTO2Param);
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate());
        System.out.println("getMessage=" + box.getMessage());
        System.out.println("getResponseCode=" + box.getResponseCode());
        return "返回值";
    }
}

