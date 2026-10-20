package com.airouter.ai_ticket_router.service;

import com.airouter.ai_ticket_router.dto.CreateTicketRequest;
import com.airouter.ai_ticket_router.dto.TicketResponse;
import com.airouter.ai_ticket_router.entity.Ticket;
import com.airouter.ai_ticket_router.entity.TicketStatus;
import com.airouter.ai_ticket_router.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;

    @Transactional
    public TicketResponse create(CreateTicketRequest request){
        Ticket ticket = new Ticket();
        ticket.setSubject(request.subject());
        ticket.setDescription(request.descrption());
        ticket.setRequesterEmail(request.requesterEmail());
        ticket.setStatus(TicketStatus.OPEN);

        return TicketResponse.from(repository.save(ticket));
    }
    @Transactional(readOnly = true)
    public TicketResponse getById(Long id){
        return TicketResponse.from(findOrThrow(id));
    }

    @Transactional(readOnly = true)
    public Page<TicketResponse> list(Pageable pageable){
        return repository.findAll(pageable).map(TicketResponse::from);
    }

    @Transactional
    public TicketResponse updateStatus(Long id, TicketStatus status){
        Ticket ticket = findOrThrow(id);
        ticket.setStatus(status);
        return TicketResponse.from(repository.save(ticket));
    }

    @Transactional
    public void delete(Long id){
        Ticket ticket = findOrThrow(id);
        repository.delete(ticket);
    }

    private Ticket findOrThrow(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ticket not found"+id));
    }

}
