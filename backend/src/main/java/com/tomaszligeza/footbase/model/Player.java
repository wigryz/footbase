package com.tomaszligeza.footbase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String fullName;
    private Date birthDate;

    @ManyToOne
    @JoinColumn
    private Team currentTeam;

    @ManyToOne
    @JoinColumn
    private Position mainPosition;

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
