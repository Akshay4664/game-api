package com.gametech.gameapi.service;

import com.gametech.gameapi.Dto.GameProgressRequest;
import com.gametech.gameapi.model.GameProgress;
import com.gametech.gameapi.model.Reward;
import com.gametech.gameapi.model.User;
import com.gametech.gameapi.repository.GameProgressRepository;
import com.gametech.gameapi.repository.RewardRepository;
import com.gametech.gameapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameProgressService {

    public GameProgressRepository gameProgressRepository;

    private RewardRepository rewardsRepository;

    public GameProgressService(GameProgressRepository gameProgressRepository, RewardRepository rewardsRepository) {
        this.gameProgressRepository = gameProgressRepository;
        this.rewardsRepository = rewardsRepository;
    }

    @Transactional
    public GameProgress saveGameProgress(User user, GameProgressRequest request){

        List<Reward> collectedRewards = request.getRewards().stream()
                .map(reward -> rewardsRepository.findById(reward.getId())
                        .orElseGet(() -> rewardsRepository.save(reward))) // Save if not exists
                .toList();

        return gameProgressRepository.save(
                GameProgress.builder()
                        .user(user)
                        .level(request.getLevel())
                        .rank(request.getRank())
                        .gold(request.getGold())
                        .cash(request.getCash())
                        .gems(request.getGems())
                        .country(request.getCountry())
                        .lastActive(request.getLastActiveTime())
                        .collectedRewards(collectedRewards)
                        .build()
        );
    }
}
