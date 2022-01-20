package com.example.backend.security.filter;

import com.example.backend.common.exception.GlobalException;
import com.example.backend.common.response.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtExceptionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request,response);
        } catch (GlobalException ex) {
            setErrorResponse(response, ex.getHttpStatus(), ex.getErrorMsg());
        }
    }

    public void setErrorResponse(HttpServletResponse response, HttpStatus status, String errorMsg){
        response.setStatus(status.value());
        response.setContentType("application/json");
        ErrorResponse errorResponse = new ErrorResponse(status.value(), errorMsg);
        try {
            String json = converToJson(errorResponse);
            System.out.println("json = " + json);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private String converToJson(ErrorResponse errorResponse) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(errorResponse);
        return json;
    }
}
