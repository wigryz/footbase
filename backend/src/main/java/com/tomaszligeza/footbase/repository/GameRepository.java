package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Integer countByRefereeId(Long id);
}
