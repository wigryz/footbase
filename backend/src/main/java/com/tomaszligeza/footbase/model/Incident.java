package com.tomaszligeza.footbase.model;

import javax.persistence.*;

@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private IncidentType incidentType;

    @ManyToOne
    private Game game;

    @ManyToOne
    @JoinColumn
    private Player player;

    public Incident() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }
}
