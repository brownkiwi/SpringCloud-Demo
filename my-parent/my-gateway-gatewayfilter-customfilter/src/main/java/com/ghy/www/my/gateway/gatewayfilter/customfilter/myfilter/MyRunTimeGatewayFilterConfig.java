package com.ghy.www.my.gateway.gatewayfilter.customfilter.myfilter;

public class MyRunTimeGatewayFilterConfig {
    private String key;
    private String value;

    public MyRunTimeGatewayFilterConfig() {
    }

    public MyRunTimeGatewayFilterConfig(String key, String value) {
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

