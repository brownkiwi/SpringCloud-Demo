package com.ghy.www.my.nacos.resttemplate.direct.consumer.controller.post;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class Test4 {
    public static void main(String[] args) {
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
        ResponseEntity<ResponseBox<UserinfoDTO2>> responseEntity = template.exchange("http://localhost:8080/post/test4", HttpMethod.POST, entity, new ParameterizedTypeReference<ResponseBox<UserinfoDTO2>>() {
        });
        ResponseBox<UserinfoDTO2> box = responseEntity.getBody();
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(box.getResponseCode() + " " + userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate() + " " + box.getMessage());
    }
}
