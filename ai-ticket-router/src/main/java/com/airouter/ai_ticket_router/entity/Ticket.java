package com.airouter.ai_ticket_router.entity;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String subject;

    @Column(nullable = false, length = 4000)
    private String description;

    @Column(nullable = false)
    private String requesterEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TicketStatus status = TicketStatus.OPEN;


    //AI Derived fields

    @Column(length = 30)
    private String priority;

    @Column(length = 40)
    private String intent;

    @Column(length = 20)
    private String sentiment;

    @Column(length = 40)
    private String suggestedTeam;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;


    public Ticket(){

    }

    @PrePersist
    void onCreate(){
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;

        if(this.status == null){
            this.status = TicketStatus.OPEN;
        }

    }

    @PreUpdate
    void onUpdate(){
        this.updatedAt = Instant.now();
    }


}
