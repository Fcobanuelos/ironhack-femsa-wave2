package com.ironhack.femsa.ecomerce_lab08.service;

import com.ironhack.femsa.ecomerce_lab08.model.OrderCustomer;

/**
 * The interface Order service.
 */
public interface OrderService {

    /**
     * Create order order.
     *
     * @param orderCustomer the order
     * @return the order
     */
    OrderCustomer createOrder(OrderCustomer orderCustomer);
}
