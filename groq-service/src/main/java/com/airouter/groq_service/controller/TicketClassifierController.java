package com.airouter.groq_service.controller;


import com.airouter.groq_service.dto.ClassifyRequest;
import com.airouter.groq_service.dto.TicketClassification;
import com.airouter.groq_service.service.TicketClassifierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketClassifierController {

    private final TicketClassifierService ticketClassifierService;

    @PostMapping("classify")
    public TicketClassification classify(@Valid @RequestBody ClassifyRequest request){

        return ticketClassifierService.classify(request);
    }
}
