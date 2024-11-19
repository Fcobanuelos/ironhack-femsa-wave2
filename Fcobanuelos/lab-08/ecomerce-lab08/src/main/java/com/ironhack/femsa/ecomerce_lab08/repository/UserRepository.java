package com.ironhack.femsa.ecomerce_lab08.repository;

import com.ironhack.femsa.ecomerce_lab08.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
