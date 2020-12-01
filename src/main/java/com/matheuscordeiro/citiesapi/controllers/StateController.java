package com.matheuscordeiro.citiesapi.controllers;

import com.matheuscordeiro.citiesapi.entities.State;
import com.matheuscordeiro.citiesapi.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    StateRepository stateRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<State> states(final Pageable page) {
        return stateRepository.findAll(page);
    }

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable Long id) {
        Optional<State> optional = stateRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
