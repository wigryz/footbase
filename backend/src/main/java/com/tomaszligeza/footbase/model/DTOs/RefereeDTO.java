package com.tomaszligeza.footbase.model.DTOs;

import java.io.Serializable;
import java.sql.Date;

public class RefereeDTO implements Serializable {
    private Long id;
    private String fullName;
    private Date birthDate;
    private Integer numberOfRefereedMatches;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getNumberOfRefereedMatches() {
        return numberOfRefereedMatches;
    }

    public void setNumberOfRefereedMatches(Integer numberOfRefereedMatches) {
        this.numberOfRefereedMatches = numberOfRefereedMatches;
    }
}
