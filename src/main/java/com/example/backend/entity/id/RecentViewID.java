package com.example.backend.entity.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentViewID implements Serializable {
    private String user;
    private Long portfolio;
}
