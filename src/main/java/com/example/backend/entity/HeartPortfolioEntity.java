package com.example.backend.entity;

import com.example.backend.common.entity.BaseEntity;
import com.example.backend.entity.PortfolioEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.id.HeartPortfolioID;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(HeartPortfolioID.class)
@Table(name = "heart_portfolio")
public class HeartPortfolioEntity extends BaseEntity {
    @Id
    @JoinColumn(name = "email")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Id
    @JoinColumn(name = "portfolio_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PortfolioEntity portfolio;
}
