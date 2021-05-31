package com.tomaszligeza.footbase.controller;

import com.tomaszligeza.footbase.model.DTOs.PlayerDTO;
import com.tomaszligeza.footbase.model.DTOs.RefereeDTO;
import com.tomaszligeza.footbase.model.Player;
import com.tomaszligeza.footbase.model.Referee;
import com.tomaszligeza.footbase.service.GameService;
import com.tomaszligeza.footbase.service.RefereeService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
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

        addCustomMappingToModelMapper();
    }

    @GetMapping("/all")
    public ResponseEntity<List<RefereeDTO>> getReferees() {
        List<Referee> referees = refereeService.findAllReferee();
        return new ResponseEntity<>(referees.stream()
                                            .map(referee -> modelMapper.map(referee, RefereeDTO.class))
                                            .collect(Collectors.toList()),
                                    HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addReferee(@RequestBody RefereeDTO refereeDTO) {
        Referee referee = modelMapper.map(refereeDTO, Referee.class);
        refereeService.addReferee(referee);
    }

    private void addCustomMappingToModelMapper() {
        Converter<Referee, RefereeDTO> refereeRefereeDTOConverter = new Converter<Referee, RefereeDTO>() {
            @Override
            public RefereeDTO convert(MappingContext<Referee, RefereeDTO> mappingContext) {
                Referee s = mappingContext.getSource();
                RefereeDTO d = mappingContext.getDestination() != null ?
                        mappingContext.getDestination() : new RefereeDTO();
                d.setId(s.getId());
                d.setFullName(s.getFullName());
                d.setBirthDate(s.getBirthDate());
                d.setNumberOfRefereedMatches(gameService.countByRefereeId(s.getId()));
                return d;
            }
        };
        modelMapper.addConverter(refereeRefereeDTOConverter);
    }
}
