package com.example.project.interfaces.facade;

import com.example.project.interfaces.dto.AccessTokenResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
public class GitHubFacade {
    private final OAuth2AuthorizedClientService authorizedClientService;
    @Value("spring.security.oauth2.client.registration.github.client.id")
    private String clientId;
    @Value("spring.security.oauth2.client.registration.github.client.secret")
    private String clientSecret;
    @GetMapping("/")
    public String homePage(){
        return "Authorize successfully!";
    }
    // 获取 GitHub Access Token
    @GetMapping("/token")
    public String getToken(@RequestParam("code") String code) {
        RestTemplate restTemplate = new RestTemplate();
        String tokenUrl = "https://github.com/login/oauth/access_token"+
                "?client_id="+clientId+
                "&client_secret="+clientSecret+
                "&code="+code;
        AccessTokenResDTO accessTokenResDTO = restTemplate.postForObject(tokenUrl,null,AccessTokenResDTO.class);
        assert accessTokenResDTO != null;
        return accessTokenResDTO.getAccessToken();
    }
}
