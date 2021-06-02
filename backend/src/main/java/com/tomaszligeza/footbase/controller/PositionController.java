package com.tomaszligeza.footbase.controller;

import com.tomaszligeza.footbase.model.Position;
import com.tomaszligeza.footbase.service.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;
    private final ModelMapper modelMapper;

    public PositionController(PositionService positionService, ModelMapper modelMapper) {
        this.positionService = positionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Position>> getAll() {
        return new ResponseEntity<>(positionService.findAll(),
                                    HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addPosition(@RequestBody Position position) {
        positionService.add(position);
    }
}
