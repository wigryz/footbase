package com.tomaszligeza.footbase.model.DTOs;

import com.tomaszligeza.footbase.model.Referee;
import com.tomaszligeza.footbase.model.Team;

import java.sql.Date;

public class GameDTOUp {
    private Long Id;
    private Integer hostScore;
    private Integer guestScore;
    private Date gameDate;
    private Long hostTeamId;
    private String hostTeamName;
    private Long guestTeamId;
    private String guestTeamName;
    private Long refereeId;
    private String refereeFullName;

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

    public Long getHostTeamId() {
        return hostTeamId;
    }

    public void setHostTeamId(Long hostTeamId) {
        this.hostTeamId = hostTeamId;
    }

    public String getHostTeamName() {
        return hostTeamName;
    }

    public void setHostTeamName(String hostTeamName) {
        this.hostTeamName = hostTeamName;
    }

    public Long getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(Long guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }

    public void setGuestTeamName(String guestTeamName) {
        this.guestTeamName = guestTeamName;
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }

    public String getRefereeFullName() {
        return refereeFullName;
    }

    public void setRefereeFullName(String refereeFullName) {
        this.refereeFullName = refereeFullName;
    }
}
