package com.matheuscordeiro.citiesapi.repositories;

import com.matheuscordeiro.citiesapi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
