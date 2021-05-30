package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Game;
import com.tomaszligeza.footbase.model.scoreboard.Scoreboard;
import com.tomaszligeza.footbase.model.scoreboard.ScoreboardTeam;
import com.tomaszligeza.footbase.repository.GameRepository;
import com.tomaszligeza.footbase.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TableService {
    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;
    private Scoreboard scoreboard = null;

    @Autowired
    public TableService(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    public Scoreboard getTable() {
        if(scoreboard == null)
            prepareTable();
        return scoreboard;
    }

    private void prepareTable() {
        List<ScoreboardTeam> teams = new ArrayList<>();
        for (var team : teamRepository.findAll()) {
            teams.add(new ScoreboardTeam(team.getTeamName()));
        }
        List<Game> games = gameRepository.findAll();
        for (var game: games) {
            ScoreboardTeam hostTeam = teams.stream()
                                                     .filter(t -> t.getTeamName() == game.getHostTeam().getTeamName())
                                                     .findFirst()
                                                     .orElseThrow();
            ScoreboardTeam guestTeam = teams.stream()
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
        teams.sort((t1, t2) -> t2.getPoints() - t1.getPoints());
        scoreboard = new Scoreboard(teams);
    }
}
