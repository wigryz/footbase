package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
