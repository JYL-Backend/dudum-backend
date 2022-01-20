package com.example.backend.security.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenDTO {
    String grantType;
    String accessToken;
    long accessTkenExpriesln;
    String refreshToken;
}
