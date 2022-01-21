package com.example.backend.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="matching_request")
public class MatchingRequestEntity {
    @Id @GeneratedValue
    private Long id;

    @JoinColumn(name="email")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Column(name = "company_name")
    private String companyName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vedeo_type_code")
    private CodeEntity videioType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_type_code")
    private CodeEntity eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="directing_type_code")
    private CodeEntity directingType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="video_duration_code")
    private CodeEntity videoDuration;

    @Column(name="plan_count")
    private int planCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="channel_code")
    private CodeEntity channel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="budget_code")
    private CodeEntity budget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="completed_code")
    private CodeEntity completed;
}
