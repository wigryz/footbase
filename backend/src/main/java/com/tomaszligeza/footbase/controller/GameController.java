package com.tomaszligeza.footbase.controller;


import com.tomaszligeza.footbase.model.DTOs.GameDTODown;
import com.tomaszligeza.footbase.model.DTOs.GameDTOUp;
import com.tomaszligeza.footbase.model.DTOs.PlayerDTO;
import com.tomaszligeza.footbase.model.Game;
import com.tomaszligeza.footbase.service.GameService;
import com.tomaszligeza.footbase.service.RefereeService;
import com.tomaszligeza.footbase.service.TeamService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;
    private final TeamService teamService;
    private final RefereeService refereeService;
    private final ModelMapper modelMapper;

    public GameController(GameService gameService, TeamService teamService, RefereeService refereeService, ModelMapper modelMapper) {
        this.gameService = gameService;
        this.teamService = teamService;
        this.refereeService = refereeService;
        this.modelMapper = modelMapper;

        addCustomMappingToModelMapper();
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameDTOUp>> getGames() {
        List<Game> games = gameService.findAllGames();
        return new ResponseEntity<>(games.stream()
                                         .map(game -> modelMapper.map(game, GameDTOUp.class))
                                         .collect(Collectors.toList()),
                                    HttpStatus.OK);
    }


    @GetMapping("/byClubId/{id}")
    @ResponseBody
    public ResponseEntity<List<GameDTOUp>> getGames(@PathVariable Long id) {
        List<Game> games = gameService.findAllByHostTeamId(id);
        games.addAll(gameService.findAllByGuestTeamId(id));
        return new ResponseEntity<>(games.stream()
                .map(game -> modelMapper.map(game, GameDTOUp.class))
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public Game addGame(@RequestBody GameDTODown gameDTODown) {
        Game game = modelMapper.map(gameDTODown, Game.class);
        return gameService.addGame(game);
    }

    private void addCustomMappingToModelMapper() {
        Converter<Game, GameDTOUp> gameDTOUpGameConverter = new Converter<Game, GameDTOUp>() {
            @Override
            public GameDTOUp convert(MappingContext<Game, GameDTOUp> mappingContext) {
                Game s = mappingContext.getSource();
                GameDTOUp d = mappingContext.getDestination() != null ?
                        mappingContext.getDestination() : new GameDTOUp();
                d.setId(s.getId());
                d.setHostScore(s.getHostScore());
                d.setGuestScore(s.getGuestScore());
                d.setGameDate(s.getGameDate());
                d.setHostTeamId(s.getHostTeam().getId());
                d.setGuestTeamId(s.getGuestTeam().getId());
                d.setRefereeId(s.getReferee().getId());
                d.setHostTeamName(s.getHostTeam().getTeamName());
                d.setGuestTeamName(s.getGuestTeam().getTeamName());
                d.setRefereeFullName(s.getReferee().getFullName());
                return d;
            }
        };

        modelMapper.addConverter(gameDTOUpGameConverter);

        Converter<GameDTODown, Game> gameDTODownGameConverter = new Converter<GameDTODown, Game>() {
            @Override
            public Game convert(MappingContext<GameDTODown, Game> mappingContext) {
                GameDTODown s = mappingContext.getSource();
                Game d = mappingContext.getDestination() != null ?
                        mappingContext.getDestination() : new Game();
                d.setId(s.getId());
                d.setHostScore(s.getHostScore());
                d.setGuestScore(s.getGuestScore());
                d.setGameDate(s.getGameDate());

                d.setHostTeam(teamService.findById(s.getHostTeamId()).orElseThrow());
                d.setGuestTeam(teamService.findById(s.getGuestTeamId()).orElseThrow());
                d.setReferee(refereeService.findById(s.getRefereeId()).orElseThrow());
                return d;
            }
        };

        modelMapper.addConverter(gameDTODownGameConverter);
    }
}