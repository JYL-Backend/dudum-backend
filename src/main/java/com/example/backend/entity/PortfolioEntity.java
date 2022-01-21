package com.example.backend.entity;

import com.example.backend.common.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="portfolio")
public class PortfolioEntity extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "portfolio_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private CompanyEntity company;

    @Column(name="title")
    private String title;

    @Column(name="video_duration")
    private int videoDuration;

    @Column(name="thumbnail_url")
    private String thumbnailUrl;

    @Column(name="youtube_url")
    private String youtubeUrl;

    @Column(name="cost")
    private int cost;

    @Column(name="create_days")
    private int createDays;

    @Column(name="view_count")
    private int viewCount;

    @Column(name="recommend_count")
    private String recommendCount;
}
