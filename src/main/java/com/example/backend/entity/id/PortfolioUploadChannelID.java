package com.example.backend.entity.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioUploadChannelID implements Serializable {
    private String channel;
    private Long portfolio;
}
