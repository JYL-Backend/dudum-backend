package com.example.backend.entity;

import com.example.backend.common.entity.BaseEntity;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "company")
public class CompanyEntity extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "email")
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @Column(name = "intro")
    private String intro;

    @Column(name = "count_member")
    private int countMember;

    @Column(name = "company_regist")
    private LocalDateTime companyRegist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_code")
    private CodeEntity cityCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code")
    private CodeEntity countryCode;

}
