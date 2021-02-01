package com.mustunal.trackzilla.service;

import com.mustunal.trackzilla.entities.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> listApplications();
    Application findApplication(Long id);
}
