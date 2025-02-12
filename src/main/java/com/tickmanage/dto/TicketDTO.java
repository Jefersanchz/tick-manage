package com.tickmanage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tickmanage.entity.TicketStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TicketDTO {
    private Long id;
    private String user;
    private String description;
    private TicketStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updatedAt;
}
