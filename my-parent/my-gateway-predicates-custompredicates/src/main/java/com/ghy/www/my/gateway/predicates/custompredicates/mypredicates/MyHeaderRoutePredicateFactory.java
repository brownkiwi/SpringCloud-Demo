package com.ghy.www.my.gateway.predicates.custompredicates.mypredicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//自定义RoutePredicateFactory类命名规则：
//自定义名称+"RoutePredicateFactory"
@Component
public class MyHeaderRoutePredicateFactory extends AbstractRoutePredicateFactory<MyHeaderRoutePredicateConfig> {
    public MyHeaderRoutePredicateFactory() {
        super(MyHeaderRoutePredicateConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyHeaderRoutePredicateConfig config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                System.out.println("config.getKey()=" + config.getKey());
                System.out.println("config.getValue()=" + config.getValue());
                //header中name属性的值
                String value = serverWebExchange.getRequest().getHeaders().getFirst(config.getKey());
                System.out.println("getFirst(config.getKey())=" + value);
                if (value == null) {
                    return false;
                } else {
                    if (value.equals(config.getValue())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        List<String> list = new ArrayList<>();
        list.add("key");//关联MyHeaderRoutePredicateConfig类的key属性
        list.add("value");//关联MyHeaderRoutePredicateConfig类的value属性
        return list;
    }
}
