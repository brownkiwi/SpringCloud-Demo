package com.ghy.www.my.nacos.resttemplate.direct.consumer.controller.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ghy.www.dto.ResponseBox;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Base64;

public class Test2 {
    public static void main(String[] args) throws JsonProcessingException {
        int id = 100;
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap map = new LinkedMultiValueMap();
        map.add("id", id);
        map.add("username", username);
        map.add("password", password);
        map.add("age", age);
        map.add("insertdate", insertdate);
        HttpEntity<String> entity = new HttpEntity(map, headers);

        RestTemplate template = new RestTemplate();
        ResponseEntity<ResponseBox<String>> responseEntity = template.exchange(URI.create("http://localhost:8080/post/test2"), HttpMethod.POST, entity, new ParameterizedTypeReference<ResponseBox<String>>() {
        });
        ResponseBox<String> box = responseEntity.getBody();
        System.out.println(box.getResponseCode() + " " + box.getData() + " " + box.getMessage());
    }
}
