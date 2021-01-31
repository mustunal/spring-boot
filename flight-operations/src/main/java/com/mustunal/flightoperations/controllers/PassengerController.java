package com.mustunal.flightoperations.controllers;

import com.mustunal.flightoperations.models.Passenger;
import com.mustunal.flightoperations.repositories.PassengerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping
    public List<Passenger> list(){
        return passengerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Passenger get(@PathVariable Long id){
        return passengerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Passenger create(@RequestBody final Passenger passenger){
        return passengerRepository.saveAndFlush(passenger);
    }

    @PostMapping
    @RequestMapping(value = "/update/{id}")
    public Passenger update(@PathVariable Long id,@RequestBody Passenger passenger){
        Passenger foundPassenger = passengerRepository.getOne(id);
        BeanUtils.copyProperties(passenger,foundPassenger,"passengerId");
        return passengerRepository.saveAndFlush(foundPassenger);
    }
}
