package com.example.project.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessTokenResDTO {
    @JsonProperty("access_token")
    private String accessToken;

    public String getAccessToken(){
        return accessToken;
    }
}
