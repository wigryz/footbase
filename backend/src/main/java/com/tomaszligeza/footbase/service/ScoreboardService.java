package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Game;
import com.tomaszligeza.footbase.model.DTOs.TeamInScoreboardDTO;
import com.tomaszligeza.footbase.repository.GameRepository;
import com.tomaszligeza.footbase.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreboardService {
    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;
    private List<TeamInScoreboardDTO> scoreboard = null;

    @Autowired
    public ScoreboardService(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    public List<TeamInScoreboardDTO> getScoreBoard() {
        if(scoreboard == null)
            prepareScoreboard();
        return scoreboard;
    }

    private void prepareScoreboard() {
        scoreboard = new ArrayList<>();
        for (var team : teamRepository.findAll()) {
            scoreboard.add(new TeamInScoreboardDTO(team.getId(), team.getTeamName()));
        }
        List<Game> games = gameRepository.findAll();
        for (var game: games) {
            TeamInScoreboardDTO hostTeam = scoreboard.stream()
                                                     .filter(t -> t.getTeamName() == game.getHostTeam().getTeamName())
                                                     .findFirst()
                                                     .orElseThrow();
            TeamInScoreboardDTO guestTeam = scoreboard.stream()
                                                      .filter(t -> t.getTeamName() == game.getGuestTeam().getTeamName())
                                                      .findFirst()
                                                      .orElseThrow();
            hostTeam.addNumberOfGames(1);
            guestTeam.addNumberOfGames(1);
            hostTeam.addGoalsScored(game.getHostScore());
            guestTeam.addGoalsScored(game.getGuestScore());
            hostTeam.addGoalsConceded(game.getGuestScore());
            guestTeam.addGoalsConceded(game.getHostScore());

            if(game.getHostScore() > game.getGuestScore()) {
                hostTeam.addWins(1);
                guestTeam.addLoses(1);
            }
            else if (game.getHostScore() < game.getGuestScore()) {
                hostTeam.addLoses(1);
                guestTeam.addWins(1);
            }
            else {
                hostTeam.addDraws(1);
                guestTeam.addDraws(1);
            }
        }
        scoreboard.sort((t1, t2) -> t2.getPoints() - t1.getPoints());
    }
}
