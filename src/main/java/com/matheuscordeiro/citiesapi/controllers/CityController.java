package com.matheuscordeiro.citiesapi.controllers;

import com.matheuscordeiro.citiesapi.entities.City;
import com.matheuscordeiro.citiesapi.entities.Country;
import com.matheuscordeiro.citiesapi.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityController {
    @Autowired
    CityRepository cityRepository;

    @GetMapping
    public Page<City> cities(final Pageable page) {
        return cityRepository.findAll(page);
    }

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable Long id) {
        Optional<City> optional = cityRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
