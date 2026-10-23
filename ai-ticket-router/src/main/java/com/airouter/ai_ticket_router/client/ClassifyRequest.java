package com.airouter.groq_service.client;

public record ClassifyRequest(
        String subject, String description
) {
}
