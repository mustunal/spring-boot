package com.mustunal.flightoperations.controllers;

import com.mustunal.flightoperations.models.Flight;
import com.mustunal.flightoperations.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Flight> list(){
        return flightRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Flight get(@PathVariable Long id){
        return flightRepository.getOne(id);
    }
}
