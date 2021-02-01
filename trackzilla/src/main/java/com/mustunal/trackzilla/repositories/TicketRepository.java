package com.mustunal.trackzilla.repositories;

import com.mustunal.trackzilla.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket,Long> {
}
