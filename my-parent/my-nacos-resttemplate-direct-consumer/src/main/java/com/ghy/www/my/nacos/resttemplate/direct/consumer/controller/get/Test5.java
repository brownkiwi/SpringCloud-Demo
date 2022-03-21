package com.ghy.www.my.nacos.resttemplate.direct.consumer.controller.get;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class Test5 {
    public static void main(String[] args) {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        RestTemplate template = new RestTemplate();
        ResponseEntity<ResponseBox<UserinfoDTO2>> responseEntity = template.exchange("http://localhost:8080/get/test5?id=" + id + "&username=" + username + "&password=" + password + "&age=" + age + "&insertdate=" + insertdate, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseBox<UserinfoDTO2>>() {
        });
        ResponseBox<UserinfoDTO2> box = responseEntity.getBody();
        UserinfoDTO2 userinfo = box.getData();
        System.out.println(box.getResponseCode() + " " + userinfo.getId() + " " + userinfo.getUsername() + " " + userinfo.getPassword() + " " + box.getMessage());
    }
}
