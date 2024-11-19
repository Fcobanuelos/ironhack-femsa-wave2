package com.ironhack.femsa.ecomerce_lab08.controller;

import com.ironhack.femsa.ecomerce_lab08.dto.CreateSupportTicketRequest;
import com.ironhack.femsa.ecomerce_lab08.model.SupportTicket;
import com.ironhack.femsa.ecomerce_lab08.service.SupportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Support controller.
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "API para Comercio Electrónico - Support", description = "Endpoints para gestionar soporte")
public class SupportController {

    private final SupportService supportService;

    /**
     * Instantiates a new Support controller.
     *
     * @param supportService the support service
     */
    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    /**
     * Create ticket response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/support/tickets")
    @Operation(summary = "Crear ticket de soporte", description = "Permite a un usuario crear un ticket de soporte")
    public ResponseEntity<?> createTicket(@RequestBody CreateSupportTicketRequest request) {
        SupportTicket ticket = new SupportTicket();
        ticket.setUserId(request.getUserId());
        ticket.setIssue(request.getIssue());
        return ResponseEntity.ok(supportService.createTicket(ticket));
    }
}

