package com.gametech.gameapi.repository;

import com.gametech.gameapi.model.GameProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameProgressRepository extends JpaRepository<GameProgress, Long> {
    Optional<GameProgress> findByUserId(Long userId);
}
