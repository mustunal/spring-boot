package com.mustunal.trackzilla.service;

import com.mustunal.trackzilla.entities.Ticket;
import com.mustunal.trackzilla.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> listTickets() {
        return (List<Ticket>)ticketRepository.findAll();
    }
}
