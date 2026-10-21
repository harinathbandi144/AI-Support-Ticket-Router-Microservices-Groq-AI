package com.airouter.groq_service.dto;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record TicketClassification(
        @JsonPropertyDescription("The Customer's Underlying Issue category. One Of BILLING, TECHNICAL_ISSUE, ACCOUNT_ACCESS, FEATURE_REQUEST, GENERAL_INPUT")
        String intent,

        @JsonPropertyDescription("Overall Emotional Tone oF the Ticket Text. One of POSITIVE, NEUTRAL, NEGATIVE")
        String sentiment,

        @JsonPropertyDescription("How Urgently this Ticket needs to be handled. One of LOW, MEDIUM, HIGH, URGENT")
        String priority,

        @JsonPropertyDescription("the Support Team best suited to own this ticket. One of: BILLING_TEAM, TECHNICAL_SUPPORT, ACCOUNT_MANAGEMENT, PRODUCT_TEAM, GENERAL_SUPPORT")
        String supportTeam

) { }
