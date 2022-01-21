package com.example.backend.entity;

import com.example.backend.common.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "cmmn_code")
public class CodeEntity extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="code")
    String code;

    @Column(name="group_code")
    String groupCode;

    @Column(name="name")
    private String name;

    @Column(name="sort")
    private int sort;
}
