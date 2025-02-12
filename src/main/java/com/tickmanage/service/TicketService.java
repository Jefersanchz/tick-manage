package com.tickmanage.service;

import com.tickmanage.dto.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {
    TicketDTO createTicket(TicketDTO ticketDTO);
    TicketDTO updateTicket(Long id, TicketDTO ticketDTO);
    void deleteTicket(Long id);
    Page<TicketDTO> getTickets(Pageable pageable);
    TicketDTO getTicketById(Long id);
    TicketDTO closeTicket(Long id);
    List<TicketDTO> getTicketsByUser(String user);

}
