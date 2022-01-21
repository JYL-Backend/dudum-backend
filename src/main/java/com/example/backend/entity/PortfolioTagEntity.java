package com.example.backend.entity;

import com.example.backend.entity.id.PortFolioTagID;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "portfolio_tag")
@IdClass(PortFolioTagID.class)
public class PortfolioTagEntity {
    @Id
    @JoinColumn(name = "portfolio_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PortfolioEntity portfolio;

    @Id
    @JoinColumn(name = "tag_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TagEntity tag ;
}
