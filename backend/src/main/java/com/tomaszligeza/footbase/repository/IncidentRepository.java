package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
