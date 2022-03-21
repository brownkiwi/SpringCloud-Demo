package com.ghy.www.my.gateway.predicates.custompredicates.mypredicates;

public class MyHeaderRoutePredicateConfig {
    private String key;
    private String value;

    public MyHeaderRoutePredicateConfig() {
    }

    public MyHeaderRoutePredicateConfig(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
