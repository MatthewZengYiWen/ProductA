package com.example.project.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/login").permitAll()  // 公开路径
                        .anyRequest().authenticated()                // 其他请求需要认证
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/home")                  // 登录成功后跳转
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/"));                     // 注销后跳转

        return http.build();
    }
}
