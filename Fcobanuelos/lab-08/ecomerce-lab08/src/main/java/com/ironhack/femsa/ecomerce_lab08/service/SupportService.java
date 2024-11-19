package com.ironhack.femsa.ecomerce_lab08.service;

import com.ironhack.femsa.ecomerce_lab08.model.SupportTicket;

/**
 * The interface Support service.
 */
public interface SupportService {

    /**
     * Create ticket support ticket.
     *
     * @param ticket the ticket
     * @return the support ticket
     */
    SupportTicket createTicket(SupportTicket ticket);
}
