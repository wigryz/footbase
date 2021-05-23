package com.tomaszligeza.footbase.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long Id;
    private String fullName;
    private Date birthDate;
    @OneToOne
    private Team currentTeam;
    @OneToOne
    private Position mainPosition;

    public Player() {
    }

    public Player(Long id, String fullName, Date birthDate, Team currentTeam, Position mainPosition) {
        Id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.currentTeam = currentTeam;
        this.mainPosition = mainPosition;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    public Position getMainPosition() {
        return mainPosition;
    }

    public void setMainPosition(Position mainPosition) {
        this.mainPosition = mainPosition;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Id=" + Id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", currentTeam=" + currentTeam +
                ", mainPosition=" + mainPosition +
                '}';
    }
}
