package com.mustunal.trackzilla.service;

import com.mustunal.trackzilla.entities.Release;
import com.mustunal.trackzilla.repositories.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService{
    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public List<Release> listReleases() {
        return (List<Release>)releaseRepository.findAll();
    }
}
