package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Position;
import com.tomaszligeza.footbase.model.Referee;
import com.tomaszligeza.footbase.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Position add(Position position) {
        return positionRepository.save(position);
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
