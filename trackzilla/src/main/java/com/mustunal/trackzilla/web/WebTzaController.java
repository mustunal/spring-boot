package com.mustunal.trackzilla.web;

import com.mustunal.trackzilla.entities.Application;
import com.mustunal.trackzilla.entities.Ticket;
import com.mustunal.trackzilla.exception.ApplicationNotFoundException;
import com.mustunal.trackzilla.service.ApplicationService;
import com.mustunal.trackzilla.service.ReleaseService;
import com.mustunal.trackzilla.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.management.relation.RelationService;
import java.util.List;

@RestController
@RequestMapping("/web-tza")
public class WebTzaController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ReleaseService releaseService;

    @Autowired
    private TicketService ticketService;

    @GetMapping
    @RequestMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> ticketList = ticketService.listTickets();
        return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications(){
        List<Application> applicationList = applicationService.listApplications();
        return new ResponseEntity<>(applicationList,HttpStatus.OK);
    }
    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable Long id){
        try {
            Application application = applicationService.findApplication(id);
            return new ResponseEntity<>(application,HttpStatus.OK);
        }
        catch (ApplicationNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Application Not Found!");
        }

    }
}
