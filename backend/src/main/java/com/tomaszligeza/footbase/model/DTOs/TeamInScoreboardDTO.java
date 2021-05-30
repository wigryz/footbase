package com.tomaszligeza.footbase.model.DTOs;

import java.io.Serializable;

public class TeamInScoreboardDTO implements Serializable {
    private long id;
    private String teamName;
    private int numberOfGames;
    private int points;
    private int wins;
    private int draws;
    private int loses;
    private int goalsScored;
    private int goalsConceded;

    public TeamInScoreboardDTO(long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void addNumberOfGames(Integer numberOfGames) {
        this.numberOfGames += numberOfGames;
    }

    public Integer getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public void addWins(Integer wins) {
        this.wins += wins;
        this.points += 3;
    }

    public Integer getDraws() {
        return draws;
    }

    public void addDraws(Integer draws) {
        this.draws += draws;
        this.points += 1;
    }

    public int getLoses() {
        return loses;
    }

    public void addLoses(Integer loses) {
        this.loses += loses;
    }

    public void addGoalsScored(Integer goalsScored) {
        this.goalsScored += goalsScored;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void addGoalsConceded(Integer goalsConceded) {
        this.goalsConceded += goalsConceded;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public long getId() {
        return id;
    }
}
