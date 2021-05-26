package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.Referee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefereeRepository extends JpaRepository<Referee, Long> {

    void deleteRefereeById(Long id);
    Optional<Referee> findRefereeById(Long id);
}
