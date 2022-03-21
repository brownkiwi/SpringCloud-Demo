package com.ghy.www.my.nacos.cluster.consumer.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Controller
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("Test1")
    public void Test1(HttpServletRequest request, HttpServletResponse response) {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        ResponseEntity<ResponseBox<UserinfoDTO2>> responseEntity = restTemplate.exchange("http://my-nacos-cluster-provider-8085/Test1?id=" + id + "&username=" + username + "&password=" + password + "&age=" + age + "&insertdate=" + insertdate, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseBox<UserinfoDTO2>>() {
        });
        ResponseBox<UserinfoDTO2> box = responseEntity.getBody();
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(box.getResponseCode() + " " + userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate() + " " + box.getMessage());
    }
}
