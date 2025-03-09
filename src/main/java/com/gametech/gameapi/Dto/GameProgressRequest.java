package com.gametech.gameapi.Dto;

import com.gametech.gameapi.model.Reward;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class GameProgressRequest {
    private Long userId;  // Instead of full User object, only userId is passed
    private Integer level;
    private Integer rank;
    private Integer gold;
    private Integer cash;
    private Integer gems;
    private String country;
    private Instant lastActiveTime;
    private List<Reward> rewards;
}
