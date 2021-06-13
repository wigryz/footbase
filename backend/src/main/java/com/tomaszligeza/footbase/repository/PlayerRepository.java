package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByCurrentTeamId(Long id);
}
