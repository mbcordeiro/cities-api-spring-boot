package com.matheuscordeiro.citiesapi.controllers;

import com.matheuscordeiro.citiesapi.entities.Country;
import com.matheuscordeiro.citiesapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Country> countries(final Pageable page) {
        return countryRepository.findAll(page);
    }

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable Long id) {
        Optional<Country> optional = countryRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
