package com.matheuscordeiro.citiesapi.repositories;

import com.matheuscordeiro.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
