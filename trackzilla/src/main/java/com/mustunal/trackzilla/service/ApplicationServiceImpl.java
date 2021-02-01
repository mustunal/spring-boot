package com.mustunal.trackzilla.service;

import com.mustunal.trackzilla.entities.Application;
import com.mustunal.trackzilla.exception.ApplicationNotFoundException;
import com.mustunal.trackzilla.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public List<Application> listApplications() {
        return (List<Application>)applicationRepository.findAll();
    }

    @Override
    public Application findApplication(Long id) {
        Optional<Application> searchResult = applicationRepository.findById(id);
        if (searchResult.isPresent())
            return searchResult.get();
        throw new ApplicationNotFoundException("Application Not Found");
    }
}
