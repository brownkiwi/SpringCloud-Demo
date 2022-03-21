package com.ghy.www.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserinfoUploadDTO {
    private String username;
    private MultipartFile uploadFile[];

    public UserinfoUploadDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile[] getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(MultipartFile[] uploadFile) {
        this.uploadFile = uploadFile;
    }
}