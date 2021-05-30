package com.tomaszligeza.footbase.controller;

import com.tomaszligeza.footbase.model.Referee;
import com.tomaszligeza.footbase.service.RefereeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/referee")
public class RefereeController {
    private final RefereeService refereeService;

    public RefereeController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Referee>> getAllReferees() {
        List<Referee> referees = refereeService.findAllReferee();
        return new ResponseEntity<>(referees, HttpStatus.OK);
    }
}
