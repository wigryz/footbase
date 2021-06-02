package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Incident;
import com.tomaszligeza.footbase.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public List<Incident> getIncidents() {
        return incidentRepository.findAll();
    }

    public Incident add(Incident incident) {
        return incidentRepository.save(incident);
    }
}
