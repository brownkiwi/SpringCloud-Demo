package com.ghy.www.my.nacos.openfeign.consumer.openfeignclient;

import com.ghy.www.dto.ResponseBox;
import com.ghy.www.dto.UserinfoDTO2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


// @RequestMapping(value = "delete") 新版不支持@RequestMapping和FeignClient一起使用，注释掉这行，不然启动会报错
@FeignClient(name = "my-nacos-provider-standalone-cluster-8085")
public interface DeleteControllerClient {
    @DeleteMapping(value = "delete/test1")
    public ResponseBox<String> test1(@RequestParam HttpServletRequest request, @RequestParam HttpServletResponse response);

    @DeleteMapping(value = "delete/test2")
    public ResponseBox<String> test2(@RequestParam String id, @RequestParam String username, @RequestParam String password, @RequestParam String age, @RequestParam String insertdate) throws UnsupportedEncodingException;

    @DeleteMapping(value = "delete/test3/id/{id}/username/{username}/password/{password}/age/{age}/insertdate/{insertdate}")
    public ResponseBox<String> test3(@PathVariable String id, @PathVariable String username, @PathVariable String password, @PathVariable String age, @PathVariable String insertdate) throws UnsupportedEncodingException;

    @DeleteMapping(value = "delete/test4")
    public ResponseBox<UserinfoDTO2> test4(@RequestParam String id, @RequestParam String username, @RequestParam String password, @RequestParam String age, @RequestParam String insertdate) throws UnsupportedEncodingException;

    @DeleteMapping(value = "delete/test5")
    public ResponseBox<UserinfoDTO2> test5(UserinfoDTO2 userinfoDTO2Param) throws UnsupportedEncodingException;

    @DeleteMapping(value = "delete/test6")
    public ResponseBox<UserinfoDTO2> test6(@RequestBody UserinfoDTO2 userinfoDTO2Param) throws UnsupportedEncodingException;
}
