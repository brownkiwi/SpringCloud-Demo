package com.ghy.www.my.gateway.globalfilter.customfilter.myfilter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入全局过滤器TokenGlobalFilter");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String tokenValue = request.getHeaders().getFirst("token");
        Map map = new HashMap();
        if (tokenValue == null || "".equals(tokenValue)) {
            map.put("key", "没有token身份信息");
            return response(response, map);
        } else {
            if (!"123".equals(tokenValue)) {
                map.put("key", "token值不是123");
                return response(response, map);
            } else {
                return chain.filter(exchange);
            }
        }
    }

    //全局过滤器的执行顺序，值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }

    private Mono<Void> response(ServerHttpResponse response, Object msg) {
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        String resJson = msg.toString();//在此处使用JSON工具将msg转换成JSON字符串，此处仅为模拟使用
        DataBuffer dataBuffer = response.bufferFactory().wrap(resJson.getBytes());
        return response.writeWith(Flux.just(dataBuffer));//响应json数据
    }
}

