package com.airouter.groq_service.dto;


import jakarta.validation.constraints.NotBlank;

public record ClassifyRequest(

        @NotBlank(message = "Subject should not be blank")
        String subject,

        @NotBlank(message = "Description should not be blank")
        String description
) {}
