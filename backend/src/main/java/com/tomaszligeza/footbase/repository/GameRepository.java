package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    Integer countByRefereeId(Long id);

    List<Game> findAllByHostTeamId(Long id);
    List<Game> findAllByGuestTeamId(Long id);
}
