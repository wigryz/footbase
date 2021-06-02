package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Incident;
import com.tomaszligeza.footbase.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    private final IncidentRepository incidentRepository;

    @Autowired
    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident add(Incident incident) {
        return incidentRepository.save(incident);
    }
}
