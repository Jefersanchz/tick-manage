package com.tickmanage.controller;

import com.tickmanage.constant.PathGeneric;
import com.tickmanage.dto.TicketDTO;
import com.tickmanage.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathGeneric.PATH_API_TICKETS)
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping(PathGeneric.PATH_CREATE_TICKET)
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(ticketService.createTicket(ticketDTO));
    }

    @PutMapping(PathGeneric.PATH_UPDATE_TICKET)
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(ticketService.updateTicket(id, ticketDTO));
    }

    @PutMapping(PathGeneric.PATH_CLOSE_TICKET)
    public ResponseEntity<TicketDTO> closeTicket(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.closeTicket(id));
    }


    @DeleteMapping(PathGeneric.PATH_DELETE_TICKET)
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(PathGeneric.PATH_GET_ALL_TICKETS)
    public ResponseEntity<Page<TicketDTO>> getTickets(Pageable pageable) {
        return ResponseEntity.ok(ticketService.getTickets(pageable));
    }

    @GetMapping(PathGeneric.PATH_GET_TICKET_BY_ID)
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }
    @GetMapping(PathGeneric.PATH_GET_TICKETS_BY_USER)
    public ResponseEntity<List<TicketDTO>> getTicketsByUser(@PathVariable String user) {
        return ResponseEntity.ok(ticketService.getTicketsByUser(user));
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
