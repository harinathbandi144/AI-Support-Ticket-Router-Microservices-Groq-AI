package com.airouter.ai_ticket_router.mapper;
import com.airouter.ai_ticket_router.dto.TicketResponse;
import com.airouter.ai_ticket_router.entity.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Ticket_Mapper {

    TicketResponse toResponse(Ticket ticket);
}
