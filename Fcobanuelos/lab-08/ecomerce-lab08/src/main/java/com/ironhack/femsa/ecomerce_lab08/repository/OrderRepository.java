package com.ironhack.femsa.ecomerce_lab08.repository;

import com.ironhack.femsa.ecomerce_lab08.model.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderCustomer, Long> {}
