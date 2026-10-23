package com.airouter.ai_ticket_router.controller;


import com.airouter.ai_ticket_router.dto.CreateTicketRequest;
import com.airouter.ai_ticket_router.dto.TicketResponse;
import com.airouter.ai_ticket_router.dto.UpdateTicketStatusRequest;
import com.airouter.ai_ticket_router.service.TicketService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    @PostMapping
    public ResponseEntity<TicketResponse> create(@RequestBody @Valid CreateTicketRequest request){
        TicketResponse response = service.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @CircuitBreaker(name="ai-ticket-router",fallbackMethod = "aiBreakerFallback")
    @Retry(name = "ai-ticket-router")
    @RateLimiter( name = "ai-ticket-router")
    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getById(@PathVariable Long id){
        TicketResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<TicketResponse> aiBreakerFallback(
            Long id, Throwable ex) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .build();
    }

//    @GetMapping
//    public Page<TicketResponse> list(@RequestParam(required = false) TicketStatus status,
//                                     @PageableDefault(size = 20, sort = "createdAt") Pageable pageable){
//        return service.list(pageable);
//    }

    @GetMapping
    public Page<TicketResponse> list(Pageable pageable){
        return service.list(pageable);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TicketResponse> updateStatus(@PathVariable Long id,@RequestBody @Valid UpdateTicketStatusRequest status){
        TicketResponse response = service.updateStatus(id, status.status());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
