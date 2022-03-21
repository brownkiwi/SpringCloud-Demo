package com.ghy.www.dto;

public class ResponseBox<T> {
    private int responseCode;
    private T data;
    private String message;

    public ResponseBox() {
    }

    public ResponseBox(int responseCode, T data, String message) {
        this.responseCode = responseCode;
        this.data = data;
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
