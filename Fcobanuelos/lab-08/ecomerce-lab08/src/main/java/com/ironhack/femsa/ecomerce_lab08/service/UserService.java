package com.ironhack.femsa.ecomerce_lab08.service;

import com.ironhack.femsa.ecomerce_lab08.model.Customer;

import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Register user user.
     *
     * @param customer the user
     * @return the user
     */
    Customer registerUser(Customer customer);

    /**
     * Login optional.
     *
     * @param email    the email
     * @param password the password
     * @return the optional
     */
    Optional<Customer> login(String email, String password);
}
