package com.mustunal.flightoperations.repositories;

import com.mustunal.flightoperations.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
