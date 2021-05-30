package com.tomaszligeza.footbase.controller;

import com.tomaszligeza.footbase.model.DTOs.PlayerDTO;
import com.tomaszligeza.footbase.model.DTOs.RefereeDTO;
import com.tomaszligeza.footbase.model.Player;
import com.tomaszligeza.footbase.model.Referee;
import com.tomaszligeza.footbase.service.PlayerService;
import com.tomaszligeza.footbase.service.PositionService;
import com.tomaszligeza.footbase.service.TeamService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final PositionService positionService;
    private final ModelMapper modelMapper;

    public PlayerController(PlayerService playerService, TeamService teamService, PositionService positionService, ModelMapper modelMapper) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.positionService = positionService;
        this.modelMapper = modelMapper;

        addCustomMappingToModelMapper();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerService.findAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addPlayer(@RequestBody PlayerDTO playerDTO) {
        playerService.addPlayer(modelMapper.map(playerDTO, Player.class));
    }

    private void addCustomMappingToModelMapper() {
        Converter<PlayerDTO, Player> playerDTOToPlayerConverter = new Converter<PlayerDTO, Player>() {
            @Override
            public Player convert(MappingContext<PlayerDTO, Player> mappingContext) {
                PlayerDTO s = mappingContext.getSource();
                Player d = mappingContext.getDestination() != null ? mappingContext.getDestination() : new Player();
                d.setFullName(s.getFullName());
                d.setBirthDate(s.getBirthDate());
                d.setCurrentTeam(teamService.findById(s.getCurrentTeamId()).orElse(null));
                d.setMainPosition(positionService.findById(s.getMainPositionId()).orElse(null));
                return d;
            }
        };
        modelMapper.addConverter(playerDTOToPlayerConverter);
    }
}