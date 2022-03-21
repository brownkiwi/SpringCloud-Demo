package com.ghy.www.my.gateway.gatewayfilter.customfilter.myfilter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

//自定义GatewayFilterFactory类命名规则：
//自定义名称+"GatewayFilterFactory"
@Component
public class MyRunTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<MyRunTimeGatewayFilterConfig> {
    public MyRunTimeGatewayFilterFactory() {
        super(MyRunTimeGatewayFilterConfig.class);
    }

    @Override
    public GatewayFilter apply(MyRunTimeGatewayFilterConfig config) {
        System.out.println("config.getKey()=" + config.getKey());
        System.out.println("config.getValue()=" + config.getValue());
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                long beginTime = System.currentTimeMillis();
                return chain.filter(exchange).then(Mono.fromRunnable(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        System.out.println("耗时：" + (endTime - beginTime));
                    }
                }));
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        List<String> list = new ArrayList<>();
        list.add("key");//关联MyRunTimeGatewayFilterConfig类的key属性
        list.add("value");//关联MyRunTimeGatewayFilterConfig类的value属性
        return list;
    }

}

