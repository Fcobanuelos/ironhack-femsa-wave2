package com.ironhack.femsa.ecomerce_lab08.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private String productId;
    private int quantity;
}
