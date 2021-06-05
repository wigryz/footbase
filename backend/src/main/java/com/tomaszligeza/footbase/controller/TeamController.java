package com.tomaszligeza.footbase.controller;

import com.tomaszligeza.footbase.model.Game;
import com.tomaszligeza.footbase.model.Team;
import com.tomaszligeza.footbase.service.GameService;
import com.tomaszligeza.footbase.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> teams = teamService.findAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Team team = teamService.findById(id).orElseThrow();
        if(team == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping("/add")
    public Team addTeam(@RequestBody Team team) {
        team.setPlayerList(new ArrayList<>());
        return teamService.addTeam(team);
    }
}