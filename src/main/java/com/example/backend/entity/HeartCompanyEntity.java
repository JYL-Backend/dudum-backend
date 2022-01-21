package com.example.backend.entity;

import com.example.backend.common.entity.BaseEntity;
import com.example.backend.entity.CompanyEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.id.HeartCompanyID;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(HeartCompanyID.class)
@Table(name = "heart_company")
public class HeartCompanyEntity  extends BaseEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

}
