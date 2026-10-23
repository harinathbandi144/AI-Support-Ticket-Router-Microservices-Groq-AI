package com.airouter.groq_service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ClassifierClient {

    private final WebClient classifierWebClient;

    public TicketClassification classify(String subject, String description){
        return classifierWebClient.post().uri("api/ticketsai")
                .bodyValue(new ClassifyRequest(subject, description))
                .retrieve()
                .bodyToMono(TicketClassification.class)
                .block();
    }
}
