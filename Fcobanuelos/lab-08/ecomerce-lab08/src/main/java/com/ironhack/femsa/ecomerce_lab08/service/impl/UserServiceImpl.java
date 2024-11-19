package com.ironhack.femsa.ecomerce_lab08.service.impl;

import com.ironhack.femsa.ecomerce_lab08.model.Customer;
import com.ironhack.femsa.ecomerce_lab08.repository.UserRepository;
import com.ironhack.femsa.ecomerce_lab08.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Customer registerUser(Customer customer) {
        return userRepository.save(customer);
    }

    @Override
    public Optional<Customer> login(String email, String password) {
        Customer customer = userRepository.findByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return Optional.of(customer);
        }
        return Optional.empty();
    }
}
