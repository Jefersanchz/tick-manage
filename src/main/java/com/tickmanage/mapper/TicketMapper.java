package com.tickmanage.mapper;

import com.tickmanage.dto.TicketDTO;
import com.tickmanage.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Ticket toEntity(TicketDTO ticketDTO);
    TicketDTO toDTO(Ticket ticket);
}
