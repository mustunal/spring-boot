package com.mustunal.conferencedemo.repositories;

import com.mustunal.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}
