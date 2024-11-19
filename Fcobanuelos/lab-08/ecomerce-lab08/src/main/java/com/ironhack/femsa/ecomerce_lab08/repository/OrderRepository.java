package com.ironhack.femsa.ecomerce_lab08.repository;

import com.ironhack.femsa.ecomerce_lab08.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
