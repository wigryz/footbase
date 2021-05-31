package com.tomaszligeza.footbase.model.DTOs;

import java.sql.Date;

public class GameDTODown {
    private Long Id;
    private Integer hostScore;
    private Integer guestScore;
    private Date gameDate;
    private Long hostTeamId;
    private Long guestTeamId;
    private Long refereeId;

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

    public Long getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(Long guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }
}
