package com.example.backend.security.config;

import com.example.backend.security.filter.JwtExceptionFilter;
import com.example.backend.security.filter.JwtFilter;
import com.example.backend.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final TokenProvider tokenProvider;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtExceptionFilter jwtExceptionFilter = new JwtExceptionFilter();
        JwtFilter customeFilter = new JwtFilter(tokenProvider);

        http.addFilterBefore(customeFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtExceptionFilter, JwtFilter.class);
    }
}
