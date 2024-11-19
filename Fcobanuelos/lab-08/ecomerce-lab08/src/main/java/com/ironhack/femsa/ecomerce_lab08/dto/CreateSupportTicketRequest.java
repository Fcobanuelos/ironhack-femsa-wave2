package com.ironhack.femsa.ecomerce_lab08.dto;

import lombok.Data;

@Data
public class CreateSupportTicketRequest {
    private Long userId;
    private String issue;
}
