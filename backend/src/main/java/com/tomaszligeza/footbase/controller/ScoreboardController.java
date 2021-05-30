package com.tomaszligeza.footbase.controller;

import com.tomaszligeza.footbase.model.DTOs.TeamInScoreboardDTO;
import com.tomaszligeza.footbase.service.ScoreboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scoreboard")
public class ScoreboardController {
    private final ScoreboardService scoreboardService;

    public ScoreboardController(ScoreboardService scoreboardService) {
        this.scoreboardService = scoreboardService;
    }

    @GetMapping
    public ResponseEntity<List<TeamInScoreboardDTO>> getScoreboard() {
        List<TeamInScoreboardDTO> listOfTeams = scoreboardService.getScoreBoard();
        return new ResponseEntity<>(listOfTeams, HttpStatus.OK);
    }
}
