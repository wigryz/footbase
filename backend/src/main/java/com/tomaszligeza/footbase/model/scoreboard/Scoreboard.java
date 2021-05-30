package com.tomaszligeza.footbase.model.scoreboard;

import java.io.Serializable;
import java.util.List;

public class Scoreboard implements Serializable {
    private List<ScoreboardTeam> rows;

    public Scoreboard(List<ScoreboardTeam> rows) {
        this.rows = rows;
    }

    public List<ScoreboardTeam> getRows() {
        return rows;
    }

    public void setRows(List<ScoreboardTeam> rows) {
        this.rows = rows;
    }
}

