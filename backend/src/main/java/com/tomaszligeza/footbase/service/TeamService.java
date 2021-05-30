package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.model.Team;
import com.tomaszligeza.footbase.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> findAllTeams() {return teamRepository.findAll(); }

    public Optional<Team> findById(Long Id) {
        return teamRepository.findById(Id);
    }
}
