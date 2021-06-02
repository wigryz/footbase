package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.IncidentType;
import com.tomaszligeza.footbase.repository.IncidentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentTypeService {
    private final IncidentTypeRepository incidentTypeRepository;

    @Autowired
    public IncidentTypeService(IncidentTypeRepository incidentTypeRepository) {
        this.incidentTypeRepository = incidentTypeRepository;
    }

    public List<IncidentType> getAll() {
        return incidentTypeRepository.findAll();
    }

    public Optional<IncidentType> findById(Long id) {
        return incidentTypeRepository.findById(id);
    }
}
