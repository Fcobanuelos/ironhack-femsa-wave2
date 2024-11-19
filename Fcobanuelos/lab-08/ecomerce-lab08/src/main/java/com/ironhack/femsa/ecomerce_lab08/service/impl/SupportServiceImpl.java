package com.ironhack.femsa.ecomerce_lab08.service.impl;

import com.ironhack.femsa.ecomerce_lab08.model.SupportTicket;
import com.ironhack.femsa.ecomerce_lab08.repository.SupportTicketRepository;
import com.ironhack.femsa.ecomerce_lab08.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Support service.
 */
@Service
public class SupportServiceImpl implements SupportService {
    @Autowired
    private SupportTicketRepository supportTicketRepository;

    /**
     * Create ticket support ticket.
     *
     * @param ticket the ticket
     * @return the support ticket
     */
    @Override
    public SupportTicket createTicket(SupportTicket ticket) {
        return supportTicketRepository.save(ticket);
    }
}
