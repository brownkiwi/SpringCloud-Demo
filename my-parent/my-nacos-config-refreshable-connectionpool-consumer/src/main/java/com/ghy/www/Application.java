package com.ghy.www;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//因为Druid有一个控制台管理界面
//所以需要启用Druid的JavaWeb Filter过滤器
@ServletComponentScan
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .run(args);
    }
}

