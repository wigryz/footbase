package com.tomaszligeza.footbase.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class IncidentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String incidentName;

    public IncidentType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIncidentName() {
        return incidentName;
    }

    public void setIncidentName(String incidentName) {
        this.incidentName = incidentName;
    }
}
