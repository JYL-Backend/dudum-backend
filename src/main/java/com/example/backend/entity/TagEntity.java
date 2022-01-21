package com.example.backend.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tag")
public class TagEntity {
    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "img_url")
    private String imgUrl;
}
