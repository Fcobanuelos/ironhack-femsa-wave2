package com.ironhack.femsa.ecomerce_lab08.service.impl;

import com.ironhack.femsa.ecomerce_lab08.model.OrderCustomer;
import com.ironhack.femsa.ecomerce_lab08.repository.OrderRepository;
import com.ironhack.femsa.ecomerce_lab08.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderCustomer createOrder(OrderCustomer orderCustomer) {
        return orderRepository.save(orderCustomer);
    }
}
