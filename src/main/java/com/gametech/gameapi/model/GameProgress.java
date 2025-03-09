package com.gametech.gameapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "game_progress")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private Integer level;
    private Integer rank;
    private Integer gold;
    private Integer cash;
    private Integer gems;
    @ManyToMany
    @JoinTable(name = "game_progress_rewards",
            joinColumns = @JoinColumn(name = "game_progress_id"),
            inverseJoinColumns = @JoinColumn(name = "reward_id")
    )
    private List<Reward> collectedRewards;
    @Column(nullable = false)
    private String country;
    @CreationTimestamp
    private Instant lastActive;

}
