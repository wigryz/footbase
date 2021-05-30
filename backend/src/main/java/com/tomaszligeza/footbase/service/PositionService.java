package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Position;
import com.tomaszligeza.footbase.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Optional<Position> findById(Long Id) {
        return positionRepository.findById(Id);
    }
}
