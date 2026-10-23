package com.airouter.ai_ticket_router.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ticketServiceOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Harinath Ticket Service")
                        .description("Project #1 - AI Router Ticket Service")
                        .version("1.0"));
    }
}
