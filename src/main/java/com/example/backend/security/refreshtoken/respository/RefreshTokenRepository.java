package com.example.backend.security.refreshtoken.respository;

import com.example.backend.security.refreshtoken.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, String> {
}
