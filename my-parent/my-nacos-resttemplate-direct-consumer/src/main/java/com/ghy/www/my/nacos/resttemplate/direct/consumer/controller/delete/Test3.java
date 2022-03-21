package com.ghy.www.my.nacos.resttemplate.direct.consumer.controller.delete;

import com.ghy.www.dto.ResponseBox;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class Test3 {
    public static void main(String[] args) {
        int id = 100;
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        RestTemplate template = new RestTemplate();
        ResponseEntity<ResponseBox<String>> responseEntity = template.exchange("http://localhost:8080/delete/test3/id/{id}/username/{username}/password/{password}/age/{age}/insertdate/{insertdate}", HttpMethod.DELETE, null, new ParameterizedTypeReference<ResponseBox<String>>() {
        }, id, username, password, age, insertdate);
        ResponseBox<String> box = responseEntity.getBody();
        System.out.println(box.getResponseCode() + " " + box.getData() + " " + box.getMessage());
    }
}