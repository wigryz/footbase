package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Game;
import com.tomaszligeza.footbase.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
