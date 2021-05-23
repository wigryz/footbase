package com.tomaszligeza.footbase.service;

import com.tomaszligeza.footbase.exception.ObjectNotFoundException;
import com.tomaszligeza.footbase.model.Referee;
import com.tomaszligeza.footbase.repo.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefereeService {
    private final RefereeRepository refereeRepo;

    @Autowired
    public RefereeService(RefereeRepository refereeRepository) {
        this.refereeRepo = refereeRepository;
    }

    public Referee addReferee(Referee referee) {
        return refereeRepo.save(referee);
    }

    public List<Referee> findAllReferee() {return refereeRepo.findAll(); }

    public Referee findRefereeById(Long id) {
        return refereeRepo.findRefereeById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object by id" + id + " was not found"));
    }

    public Referee updateReferee(Referee referee) {
        return refereeRepo.save(referee);
    }

    public String deleteReferee(Long Id) {
        refereeRepo.deleteRefereeById(Id);
        return "ok";
    }
}
