package com.mustunal.conferencedemo.repositories;

import com.mustunal.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
