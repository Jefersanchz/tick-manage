package com.tickmanage.service.impl;

import com.tickmanage.dto.TicketDTO;
import com.tickmanage.entity.Ticket;
import com.tickmanage.entity.TicketStatus;
import com.tickmanage.mapper.TicketMapper;
import com.tickmanage.repository.TicketRepository;
import com.tickmanage.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketMapper.toDTO(ticketRepository.save(ticket));
    }


    @Override
    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        try {
            Ticket ticket = ticketRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Ticket not found"));
            if (ticket.getStatus() == TicketStatus.CLOSED) {
                throw new IllegalStateException("Cannot update a closed ticket.");
            }
            if (ticketDTO.getUser() != null) {
                ticket.setUser(ticketDTO.getUser());
            }
            if (ticketDTO.getDescription() != null) {
                ticket.setDescription(ticketDTO.getDescription());
            }
            ticket.setUpdatedAt(LocalDateTime.now());

            return ticketMapper.toDTO(ticketRepository.save(ticket));

        } catch (IllegalStateException e) {
            throw new RuntimeException("Cannot update a closed ticket: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error updating ticket: " + e.getMessage());
        }
    }


    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
    @Override
    public List<TicketDTO> getTicketsByUser(String user) {
        return ticketRepository.findByUser(user)
                .stream()
                .map(ticketMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<TicketDTO> getTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable).map(ticketMapper::toDTO);
    }

    @Override
    public TicketDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        return ticketMapper.toDTO(ticket);
    }

    @Override
    public TicketDTO closeTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (ticket.getStatus() == TicketStatus.CLOSED) {
            throw new IllegalStateException("Ticket is already closed.");
        }

        ticket.setStatus(TicketStatus.CLOSED);
        ticket.setUpdatedAt(LocalDateTime.now());

        return ticketMapper.toDTO(ticketRepository.save(ticket));
    }
}
