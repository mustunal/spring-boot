package com.mustunal.trackzilla.web;

import com.mustunal.trackzilla.entities.Application;
import com.mustunal.trackzilla.entities.Ticket;
import com.mustunal.trackzilla.exception.ApplicationNotFoundException;
import com.mustunal.trackzilla.service.ApplicationService;
import com.mustunal.trackzilla.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tza-rest")
public class TzaController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> listApplications() {
        List<Application> applicationList = applicationService.listApplications();
        return new ResponseEntity<>(applicationList, HttpStatus.OK);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> listTickets() {
        List<Ticket> ticketList = ticketService.listTickets();
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable Long id) {
        try {
            Application application = applicationService.findApplication(id);
            return new ResponseEntity<>(application, HttpStatus.OK);
        } catch (ApplicationNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found!");
        }
    }
}
