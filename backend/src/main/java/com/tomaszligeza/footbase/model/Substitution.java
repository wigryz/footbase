package com.tomaszligeza.footbase.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Substitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Game game;

    @ManyToOne
    @JoinColumn
    private Player ingoingPlayer;

    @ManyToOne
    @JoinColumn
    private Player outgoingPlayer;
    private Integer minute;

    public Substitution() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getIngoingPlayer() {
        return ingoingPlayer;
    }

    public void setIngoingPlayer(Player ingoingPlayer) {
        this.ingoingPlayer = ingoingPlayer;
    }

    public Player getOutgoingPlayer() {
        return outgoingPlayer;
    }

    public void setOutgoingPlayer(Player outgoingPlayer) {
        this.outgoingPlayer = outgoingPlayer;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }
}
