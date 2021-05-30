package com.tomaszligeza.footbase.controller;

import com.tomaszligeza.footbase.model.scoreboard.Scoreboard;
import com.tomaszligeza.footbase.service.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("")
    public ResponseEntity<Scoreboard> getTable() {
        Scoreboard scoreboard = tableService.getTable();
        return new ResponseEntity<Scoreboard>(scoreboard, HttpStatus.OK);
    }
}
