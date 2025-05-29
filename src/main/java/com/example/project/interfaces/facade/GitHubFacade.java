package com.example.project.interfaces.facade;

import lombok.RequiredArgsConstructor;
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

    // 获取 GitHub Access Token
    @GetMapping("/token")
    public String getToken(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName()
        );
        return "GitHub Access Token: " + client.getAccessToken().getTokenValue();
    }
}
