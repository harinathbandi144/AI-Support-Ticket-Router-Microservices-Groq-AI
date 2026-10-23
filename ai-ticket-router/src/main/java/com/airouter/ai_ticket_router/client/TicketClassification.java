package com.airouter.ai_ticket_router.client;

public record TicketClassification(
        String intent,
        String sentiment,
        String priority,
        String suggestedTeam
        ) {
}
