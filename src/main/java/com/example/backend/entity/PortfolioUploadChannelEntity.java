package com.example.backend.entity;

import com.example.backend.entity.id.PortfolioUploadChannelID;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "portfolio_upload_channel")
@IdClass(PortfolioUploadChannelID.class)
public class PortfolioUploadChannelEntity {
    @Id
    @JoinColumn(name= "channel_code")
    @ManyToOne(fetch = FetchType.LAZY)
    private CodeEntity channel;

    @Id
    @JoinColumn(name= "portfolio_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PortfolioEntity portfolio;

    @Column(name = "sort")
    private int sort;
}
