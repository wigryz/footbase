package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
