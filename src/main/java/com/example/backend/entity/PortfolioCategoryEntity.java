package com.example.backend.entity;

import com.example.backend.common.entity.BaseEntity;
import com.example.backend.entity.id.PortfolioCategoryID;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "portfolio_category")
@IdClass(PortfolioCategoryID.class)
public class PortfolioCategoryEntity extends BaseEntity {
    @Id
    @JoinColumn(name = "category_code")
    @ManyToOne(fetch = FetchType.LAZY)
    private CodeEntity category;

    @Id
    @JoinColumn(name = "portfolio_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PortfolioEntity portfolio;
}
