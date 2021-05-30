package com.tomaszligeza.footbase.controller;

import com.tomaszligeza.footbase.model.DTOs.RefereeDTO;
import com.tomaszligeza.footbase.model.Referee;
import com.tomaszligeza.footbase.service.GameService;
import com.tomaszligeza.footbase.service.RefereeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/referee")
public class RefereeController {
    private final RefereeService refereeService;
    private final GameService gameService;
    private final ModelMapper modelMapper;

    @Autowired
    public RefereeController(RefereeService refereeService, GameService gameService, ModelMapper modelMapper) {
        this.refereeService = refereeService;
        this.gameService = gameService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RefereeDTO>> getReferees() {
        List<Referee> referees = refereeService.findAllReferee();
        return new ResponseEntity<>(referees.stream()
                                            .map(this::convertToDTO)
                                            .collect(Collectors.toList()),
                                    HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addReferee(@RequestBody RefereeDTO refereeDTO) {
        Referee referee = modelMapper.map(refereeDTO, Referee.class);
        refereeService.addReferee(referee);
    }

    private RefereeDTO convertToDTO(Referee referee) {
        RefereeDTO refereeDTO = modelMapper.map(referee, RefereeDTO.class);
        refereeDTO.setNumberOfRefereedMatches(gameService.countByRefereeId(referee.getId()));
        return refereeDTO;
    }

    private Referee convertToEntity(RefereeDTO refereeDTO) {
        return modelMapper.map(refereeDTO, Referee.class);
    }
}
