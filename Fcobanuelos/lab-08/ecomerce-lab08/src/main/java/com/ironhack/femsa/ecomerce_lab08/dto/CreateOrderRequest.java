package com.ironhack.femsa.ecomerce_lab08.dto;

import lombok.Data;
import java.util.List;

/**
 * The type Create order request.
 */
@Data
public class CreateOrderRequest {
    private Long userId;
    private List<OrderItemDto> products;
}
