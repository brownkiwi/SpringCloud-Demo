package com.ghy.www.my.nacos.resttemplate.spring.consumer.controller;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Controller
public class TestController2 {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/test5_2")
    public void get_test5_2(HttpServletRequest request, HttpServletResponse response) {
        String id = "1";
        String username = "账号~!@#$%^&*()_+-={}[]|;:'<>?,./";
        String password = "密码~!@#$%^&*()_+-={}[]|;:'<>?,./";
        username = Base64.getUrlEncoder().encodeToString(username.getBytes());
        password = Base64.getUrlEncoder().encodeToString(password.getBytes());
        String age = "100";
        String insertdate = "2000-01-01";

        ResponseEntity<ResponseBox<UserinfoDTO2>> responseEntity = restTemplate.exchange("http://my-nacos-provider-standalone-cluster-8085/get/test5?id=" + id + "&username=" + username + "&password=" + password + "&age=" + age + "&insertdate=" + insertdate, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseBox<UserinfoDTO2>>() {
        });
        ResponseBox<UserinfoDTO2> box = responseEntity.getBody();
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(box.getResponseCode() + " " + userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate() + " " + box.getMessage());
    }

    @GetMapping("/post/test5_2")
    public void post_test5_2(HttpServletRequest request, HttpServletResponse response) {
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

        ResponseEntity<ResponseBox<UserinfoDTO2>> responseEntity = restTemplate.exchange("http://my-nacos-provider-standalone-cluster-8085/post/test5", HttpMethod.POST, entity, new ParameterizedTypeReference<ResponseBox<UserinfoDTO2>>() {
        });
        ResponseBox<UserinfoDTO2> box = responseEntity.getBody();
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(box.getResponseCode() + " " + userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate() + " " + box.getMessage());
    }

    @GetMapping("/put/test5_2")
    public void put_test5_2(HttpServletRequest request, HttpServletResponse response) {
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

        ResponseEntity<ResponseBox<UserinfoDTO2>> responseEntity = restTemplate.exchange("http://my-nacos-provider-standalone-cluster-8085/put/test5", HttpMethod.PUT, entity, new ParameterizedTypeReference<ResponseBox<UserinfoDTO2>>() {
        });
        ResponseBox<UserinfoDTO2> box = responseEntity.getBody();
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(box.getResponseCode() + " " + userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate() + " " + box.getMessage());
    }

    @GetMapping("/delete/test5_2")
    public void delete_test5_2(HttpServletRequest request, HttpServletResponse response) {
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

        ResponseEntity<ResponseBox<UserinfoDTO2>> responseEntity = restTemplate.exchange("http://my-nacos-provider-standalone-cluster-8085/delete/test5", HttpMethod.DELETE, entity, new ParameterizedTypeReference<ResponseBox<UserinfoDTO2>>() {
        });
        ResponseBox<UserinfoDTO2> box = responseEntity.getBody();
        UserinfoDTO2 userinfoDTO2 = box.getData();
        System.out.println(box.getResponseCode() + " " + userinfoDTO2.getId() + " " + userinfoDTO2.getUsername() + " " + userinfoDTO2.getPassword() + " " + userinfoDTO2.getAge() + " " + userinfoDTO2.getInsertdate() + " " + box.getMessage());
    }
}
