package com.ghy.www.my.nacos.openfeign.consumer.openfeignclient;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

// @RequestMapping("get")
@FeignClient(name = "my-nacos-provider-standalone-cluster-8085")
public interface GetControllerClient {
    @GetMapping(value = "get/test1")
    public ResponseBox<String> test1(@RequestParam HttpServletRequest request, @RequestParam HttpServletResponse response);

    @GetMapping(value = "get/test2")
    public ResponseBox<String> test2(@RequestParam String id, @RequestParam String username, @RequestParam String password, @RequestParam String age, @RequestParam String insertdate) throws UnsupportedEncodingException;

    @GetMapping(value = "get/test3/id/{id}/username/{username}/password/{password}/age/{age}/insertdate/{insertdate}")
    public ResponseBox<String> test3(@PathVariable String id, @PathVariable String username, @PathVariable String password, @PathVariable String age, @PathVariable String insertdate) throws UnsupportedEncodingException;

    @GetMapping(value = "get/test4")
    public ResponseBox<UserinfoDTO2> test4(@RequestParam String id, @RequestParam String username, @RequestParam String password, @RequestParam String age, @RequestParam String insertdate) throws UnsupportedEncodingException;

    @GetMapping(value = "get/test5")
    public ResponseBox<UserinfoDTO2> test5(UserinfoDTO2 userinfoDTO2Param) throws UnsupportedEncodingException;

    @GetMapping(value = "get/test6")
    public ResponseBox<UserinfoDTO2> test6(@RequestBody UserinfoDTO2 userinfoDTO2Param) throws UnsupportedEncodingException;
}
