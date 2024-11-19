package com.ironhack.femsa.ecomerce_lab08.service;

import com.ironhack.femsa.ecomerce_lab08.model.User;

import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Register user user.
     *
     * @param user the user
     * @return the user
     */
    User registerUser(User user);

    /**
     * Login optional.
     *
     * @param email    the email
     * @param password the password
     * @return the optional
     */
    Optional<User> login(String email, String password);
}
