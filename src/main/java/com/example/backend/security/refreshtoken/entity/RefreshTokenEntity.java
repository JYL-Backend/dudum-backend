package com.example.backend.security.refreshtoken.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name="refresh_token")
public class RefreshTokenEntity {
    @Id
    private String email;
    private String token;
    public RefreshTokenEntity updateValue(String token){
        this.token = token;

        return this;
    }

    @Builder
    public RefreshTokenEntity(String id, String token){
        this.email = id;
        this.token = token;
    }
}
