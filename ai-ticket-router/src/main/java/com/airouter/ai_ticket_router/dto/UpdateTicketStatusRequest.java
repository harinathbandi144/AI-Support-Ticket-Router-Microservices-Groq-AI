package com.airouter.ai_ticket_router.dto;

import com.airouter.ai_ticket_router.entity.TicketStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateTicketStatusRequest(

        @NotNull(message = "Status should be not null")
        TicketStatus status
) {
}
