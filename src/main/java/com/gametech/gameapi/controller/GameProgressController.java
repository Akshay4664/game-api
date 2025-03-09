package com.gametech.gameapi.controller;

import com.gametech.gameapi.Dto.GameProgressRequest;
import com.gametech.gameapi.model.GameProgress;
import com.gametech.gameapi.model.User;
import com.gametech.gameapi.repository.UserRepository;
import com.gametech.gameapi.service.GameProgressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameProgressController {
    private final GameProgressService gameProgressService;
    private final UserRepository userRepository; // Fetch user from DB

    public GameProgressController(GameProgressService gameProgressService, UserRepository userRepository) {
        this.gameProgressService = gameProgressService;
        this.userRepository = userRepository;
    }

    @PostMapping("/progress")
    public ResponseEntity<?> saveGameProgress(@RequestBody GameProgressRequest request) {
        // Fetch user from database
        User user = userRepository.findById(request.getUserId()).orElse(null);

        if (user == null) {
            System.out.println("User not found with ID: " + request.getUserId()); // Log missing user
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + request.getUserId() + " not found.");
        }

        return ResponseEntity.ok(gameProgressService.saveGameProgress(user, request));
    }
}
