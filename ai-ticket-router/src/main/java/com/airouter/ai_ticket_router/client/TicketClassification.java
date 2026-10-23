package com.airouter.groq_service.client;

public record TicketClassification(
        String intent,
        String sentiment,
        String priority,
        String suggestedTeam
        ) {
}
