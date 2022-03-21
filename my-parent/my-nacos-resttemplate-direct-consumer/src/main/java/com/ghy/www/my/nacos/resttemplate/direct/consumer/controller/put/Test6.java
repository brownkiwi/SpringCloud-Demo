package com.ghy.www.my.nacos.resttemplate.direct.consumer.controller.put;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class Test6 {
    public static void main(String[] args) throws JsonProcessingException {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserinfoDTO2 userinfoDTO2Param = new UserinfoDTO2();
        userinfoDTO2Param.setId(id);
        userinfoDTO2Param.setUsername(username);
        userinfoDTO2Param.setPassword(password);
        userinfoDTO2Param.setAge(age);
        userinfoDTO2Param.setInsertdate(insertdate);

        HttpEntity<String> entity = new HttpEntity(userinfoDTO2Param, headers);

        RestTemplate template = new RestTemplate();
        ResponseEntity<ResponseBox<UserinfoDTO2>> responseEntity = template.exchange("http://localhost:8080/put/test6", HttpMethod.PUT, entity, new ParameterizedTypeReference<ResponseBox<UserinfoDTO2>>() {
        });
        ResponseBox<UserinfoDTO2> box = responseEntity.getBody();
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(box.getResponseCode() + " " + userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate() + " " + box.getMessage());
    }
}