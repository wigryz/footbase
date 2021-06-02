package com.tomaszligeza.footbase.repository;

import com.tomaszligeza.footbase.model.IncidentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentTypeRepository extends JpaRepository<IncidentType, Long> {
}
