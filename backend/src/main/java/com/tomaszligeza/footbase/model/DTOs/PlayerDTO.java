package com.tomaszligeza.footbase.model.DTOs;

import java.io.Serializable;
import java.sql.Date;

public class PlayerDTO implements Serializable {
    private String fullName;
    private Date birthDate;
    private Long currentTeamId;
    private Long mainPositionId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getCurrentTeamId() {
        return currentTeamId;
    }

    public void setCurrentTeamId(Long currentTeamId) {
        this.currentTeamId = currentTeamId;
    }

    public Long getMainPositionId() {
        return mainPositionId;
    }

    public void setMainPositionId(Long mainPositionId) {
        this.mainPositionId = mainPositionId;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", currentTeamId=" + currentTeamId +
                ", mainPositionId=" + mainPositionId +
                '}';
    }
}
