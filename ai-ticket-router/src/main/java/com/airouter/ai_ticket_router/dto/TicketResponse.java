package com.airouter.ai_ticket_router.dto;

import com.airouter.ai_ticket_router.entity.Ticket;
import com.airouter.ai_ticket_router.entity.TicketStatus;

import java.time.Instant;

public record TicketResponse(
        Long id,
        String subject,
        String description,
        String requesterEmail,
        TicketStatus status,
        String priority,
        String sentiment,
        String intent,
        String suggestedTeam,
        Instant createdAt,
        Instant updatedAt

) {

    public static TicketResponse from(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getSubject(),
                ticket.getDescription(),
                ticket.getRequesterEmail(),
                ticket.getStatus(),
                ticket.getPriority(),
                ticket.getSentiment(),
                ticket.getIntent(),
                ticket.getSuggestedTeam(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt()
        );
    }
}
