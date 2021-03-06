package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Game;
import com.tomaszligeza.footbase.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> findAllGames() {return gameRepository.findAll(); }

    public Integer countByRefereeId(Long id) {
        return gameRepository.countByRefereeId(id);
    }

    public Optional<Game> findGameById(Long id) {
        return gameRepository.findById(id);
    }

    public List<Game> findAllByHostTeamId(Long id) {
        return gameRepository.findAllByHostTeamId(id);
    }

    public List<Game> findAllByGuestTeamId(Long id) {
        return gameRepository.findAllByGuestTeamId(id);
    }
}
