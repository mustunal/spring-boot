package com.mustunal.flightoperations.repositories;

import com.mustunal.flightoperations.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
