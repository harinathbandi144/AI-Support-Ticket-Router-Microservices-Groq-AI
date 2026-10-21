
package com.airouter.groq_service.service;

import com.airouter.groq_service.dto.ClassifyRequest;
import com.airouter.groq_service.dto.TicketClassification;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketClassifierService {

    private final ChatClient chatClient;

    private static final PromptTemplate CLASSIFY_TEMPLATE =
            new PromptTemplate("""
                    You are a support ticket triage assistant
                    in a SaaS company.

                    Read the ticket below and classify it using
                    only the text provided.

                    Subject: {subject}
                    Description: {description}

                    Rules:
                    - Intent must be one of:
                      BILLING, TECHNICAL_ISSUE, ACCOUNT_ACCESS,
                      FEATURE_REQUEST, GENERAL_INPUT.

                    - Sentiment must be one of:
                      POSITIVE, NEUTRAL, NEGATIVE.

                    - Priority must be one of:
                      LOW, MEDIUM, HIGH, URGENT.

                    - Support team must be one of:
                      BILLING_TEAM, TECHNICAL_SUPPORT,
                      ACCOUNT_MANAGEMENT, PRODUCT_TEAM,
                      GENERAL_SUPPORT.

                    Return the classification as structured data
                    matching the TicketClassification fields.
                    Do not invent information that is not present
                    in the ticket.
                    """);

    public TicketClassification classify(ClassifyRequest request) {

        return chatClient.prompt()
                .user(user -> user
                        .text(CLASSIFY_TEMPLATE.getTemplate())
                        .param("subject", request.subject())
                        .param("description", request.description()))
                .call()
                .entity(TicketClassification.class);
    }
}
