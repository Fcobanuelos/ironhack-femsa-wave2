package com.ironhack.femsa.ecomerce_lab08.service;

import com.ironhack.femsa.ecomerce_lab08.model.Order;

/**
 * The interface Order service.
 */
public interface OrderService {

    /**
     * Create order order.
     *
     * @param order the order
     * @return the order
     */
    Order createOrder(Order order);
}
