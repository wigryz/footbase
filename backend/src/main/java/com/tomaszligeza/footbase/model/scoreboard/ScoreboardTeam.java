package com.tomaszligeza.footbase.model.scoreboard;

import java.io.Serializable;

public class ScoreboardTeam implements Serializable {
    private String teamName;
    private int numberOfGames;
    private int points;
    private int wins;
    private int draws;
    private int loses;
    private int goalsScored;
    private int goalsConceded;

    public ScoreboardTeam() {
    }

    public ScoreboardTeam(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getNumberOfGames() {
        return numberOfGames;
    }

    public void addNumberOfGames(Integer numberOfGames) {
        this.numberOfGames += numberOfGames;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer getWins() {
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

    public Integer getLoses() {
        return loses;
    }

    public void addLoses(Integer loses) {
        this.loses += loses;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void addGoalsScored(Integer goalsScored) {
        this.goalsScored += goalsScored;
    }

    public Integer getGoalsConceded() {
        return goalsConceded;
    }

    public void addGoalsConceded(Integer goalsConceded) {
        this.goalsConceded += goalsConceded;
    }
}
