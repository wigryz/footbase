package com.tomaszligeza.footbase.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer hostScore;
    private Integer guestScore;
    private Date gameDate;

    @ManyToOne
    @JoinColumn
    private Team hostTeam;

    @ManyToOne
    @JoinColumn
    private Team guestTeam;

    @ManyToOne
    @JoinColumn
    private Referee referee;

    public Game() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getHostScore() {
        return hostScore;
    }

    public void setHostScore(Integer hostScore) {
        this.hostScore = hostScore;
    }

    public Integer getGuestScore() {
        return guestScore;
    }

    public void setGuestScore(Integer guestScore) {
        this.guestScore = guestScore;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public Team getHostTeam() {
        return hostTeam;
    }

    public void setHostTeam(Team hostTeam) {
        this.hostTeam = hostTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}
