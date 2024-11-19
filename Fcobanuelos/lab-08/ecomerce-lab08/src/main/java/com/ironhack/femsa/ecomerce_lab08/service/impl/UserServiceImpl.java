package com.ironhack.femsa.ecomerce_lab08.service.impl;

import com.ironhack.femsa.ecomerce_lab08.model.User;
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
    public User registerUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public Optional<User> login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
