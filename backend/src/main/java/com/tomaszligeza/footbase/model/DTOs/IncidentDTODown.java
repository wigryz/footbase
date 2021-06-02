package com.tomaszligeza.footbase.model.DTOs;

import java.io.Serializable;

public class IncidentDTODown implements Serializable {
    private Long id;
    private Long incidentTypeId;
    private Long gameId;
    private Long playerId;
    private Long minute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(Long incidentTypeId) {
        this.incidentTypeId = incidentTypeId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getMinute() {
        return minute;
    }

    public void setMinute(Long minute) {
        this.minute = minute;
    }
}
