package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
