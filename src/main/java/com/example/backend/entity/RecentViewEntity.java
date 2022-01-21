package com.example.backend.entity;

import com.example.backend.common.entity.BaseEntity;
import com.example.backend.entity.PortfolioEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.id.RecentViewID;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "recent_view")
@IdClass(RecentViewID.class)
public class RecentViewEntity extends BaseEntity {
    @Id
    @JoinColumn(name = "email")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Id
    @JoinColumn(name = "emailportfolio_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PortfolioEntity portfolio;
}
