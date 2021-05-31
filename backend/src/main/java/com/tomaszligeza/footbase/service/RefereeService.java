package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.exception.ObjectNotFoundException;
import com.tomaszligeza.footbase.model.Referee;
import com.tomaszligeza.footbase.repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeService {
    private final RefereeRepository refereeRepository;

    @Autowired
    public RefereeService(RefereeRepository refereeRepository) {
        this.refereeRepository = refereeRepository;
    }

    public Referee addReferee(Referee referee) {
        return refereeRepository.save(referee);
    }

    public List<Referee> findAllReferee() {return refereeRepository.findAll(); }

    public Optional<Referee> findById(Long id) {
        return refereeRepository.findById(id);
    }

    public Referee updateReferee(Referee referee) {
        return refereeRepository.save(referee);
    }

    public String deleteReferee(Long Id) {
        refereeRepository.deleteById(Id);
        return "ok";
    }
}
