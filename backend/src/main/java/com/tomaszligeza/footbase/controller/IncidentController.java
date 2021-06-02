package com.tomaszligeza.footbase.controller;


import com.tomaszligeza.footbase.model.DTOs.IncidentDTODown;
import com.tomaszligeza.footbase.model.DTOs.IncidentDTOUp;
import com.tomaszligeza.footbase.model.Incident;
import com.tomaszligeza.footbase.service.GameService;
import com.tomaszligeza.footbase.service.IncidentService;
import com.tomaszligeza.footbase.service.IncidentTypeService;
import com.tomaszligeza.footbase.service.PlayerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/incident")
public class IncidentController {
    private final IncidentService incidentService;
    private final IncidentTypeService incidentTypeService;
    private final GameService gameService;
    private final PlayerService playerService;
    private final ModelMapper modelMapper;

    public IncidentController(IncidentService incidentService, IncidentTypeService incidentTypeService, GameService gameService, PlayerService playerService, ModelMapper modelMapper) {
        this.incidentService = incidentService;
        this.incidentTypeService = incidentTypeService;
        this.gameService = gameService;
        this.playerService = playerService;
        this.modelMapper = modelMapper;

        addCustomMappingToModelMapper();
    }


    @GetMapping("/all")
    public ResponseEntity<List<IncidentDTOUp>> getAll() {
        List<Incident> incidents = incidentService.getAllIncidents();
        return new ResponseEntity<>(incidents.stream()
                                              .map(incident -> modelMapper.map(incident, IncidentDTOUp.class))
                                              .collect(Collectors.toList()),
                                    HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Incident> add(@RequestBody IncidentDTODown incidentDTODown) {
        Incident incident = modelMapper.map(incidentDTODown, Incident.class);
        return new ResponseEntity<>(incidentService.add(incident),
                                    HttpStatus.OK);
    }

    private void addCustomMappingToModelMapper() {
        Converter<IncidentDTODown, Incident> incidentDTOIncidentConverter = new Converter<IncidentDTODown, Incident>() {
            @Override
            public Incident convert(MappingContext<IncidentDTODown, Incident> mappingContext) {
                IncidentDTODown s = mappingContext.getSource();
                Incident d = mappingContext.getDestination() != null ?
                        mappingContext.getDestination() : new Incident();
                d.setId(s.getId());
                d.setIncidentType(incidentTypeService.findById(s.getIncidentTypeId()).orElseThrow());
                d.setGame(gameService.findGameById(s.getGameId()).orElseThrow());
                d.setPlayer(playerService.findPlayerById(s.getPlayerId()).orElseThrow());
                d.setMinute(s.getMinute());
                return d;
            }
        };
        modelMapper.addConverter(incidentDTOIncidentConverter);

        Converter<Incident, IncidentDTOUp> incidentIncidentDTOUpConverter = new Converter<Incident, IncidentDTOUp>() {
            @Override
            public IncidentDTOUp convert(MappingContext<Incident, IncidentDTOUp> mappingContext) {
                Incident s = mappingContext.getSource();
                IncidentDTOUp d = mappingContext.getDestination() != null ?
                        mappingContext.getDestination() : new IncidentDTOUp();
                d.setId(s.getId());
                d.setIncidentTypeId(s.getIncidentType().getId());
                d.setIncidentName(s.getIncidentType().getIncidentName());
                d.setGameId(s.getGame().getId());
                d.setPlayerId(s.getPlayer().getId());
                d.setPlayerName(s.getPlayer().getFullName());
                d.setMinute(s.getMinute());
                return d;
            }
        };
        modelMapper.addConverter(incidentIncidentDTOUpConverter);
    }
}
