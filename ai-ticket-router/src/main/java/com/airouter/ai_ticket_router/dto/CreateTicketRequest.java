package com.airouter.ai_ticket_router.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTicketRequest(

        @NotBlank(message = "subject should not be blank")
        @Size(max = 200, message = "Subject should not exceed 200 characters")
        String subject,

        @NotBlank(message = "description should not be blank")
        @Size(max = 4000, message = "description should not exceed 4000")
        String descrption,

        @NotBlank(message = "requesterEmail should not be blank")
        @Email(message = "requesterEmail must be a valid email")
        String requesterEmail
)
{}

