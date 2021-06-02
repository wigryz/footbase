package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.exception.ObjectNotFoundException;
import com.tomaszligeza.footbase.model.Player;
import com.tomaszligeza.footbase.model.Player;
import com.tomaszligeza.footbase.repository.PlayerRepository;
import com.tomaszligeza.footbase.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> findAllPlayers() {return playerRepository.findAll(); }

    public Optional<Player> findPlayerById(Long id) {
        return playerRepository.findById(id);
    }
}
