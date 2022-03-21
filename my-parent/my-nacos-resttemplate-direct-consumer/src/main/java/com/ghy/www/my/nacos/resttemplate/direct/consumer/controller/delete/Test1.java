package com.ghy.www.my.nacos.resttemplate.direct.consumer.controller.delete;

import com.ghy.www.dto.ResponseBox;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class Test1 {
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<ResponseBox<String>> responseEntity = template.exchange(URI.create("http://localhost:8080/delete/test1"), HttpMethod.DELETE, null, new ParameterizedTypeReference<ResponseBox<String>>() {
        });
        ResponseBox<String> box = responseEntity.getBody();
        System.out.println(box.getResponseCode() + " " + box.getData() + " " + box.getMessage());
    }
}