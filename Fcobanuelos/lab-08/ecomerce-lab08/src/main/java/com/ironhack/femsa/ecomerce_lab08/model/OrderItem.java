package com.ironhack.femsa.ecomerce_lab08.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderItem {
    private String productId;
    private int quantity;
}
