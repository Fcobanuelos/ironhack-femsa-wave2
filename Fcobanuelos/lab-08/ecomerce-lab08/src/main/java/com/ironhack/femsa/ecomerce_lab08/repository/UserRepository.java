package com.ironhack.femsa.ecomerce_lab08.repository;

import com.ironhack.femsa.ecomerce_lab08.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
