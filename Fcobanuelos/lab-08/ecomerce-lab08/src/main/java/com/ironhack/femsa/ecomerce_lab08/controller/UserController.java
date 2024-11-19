package com.ironhack.femsa.ecomerce_lab08.controller;

import com.ironhack.femsa.ecomerce_lab08.dto.LoginRequest;
import com.ironhack.femsa.ecomerce_lab08.dto.RegisterUserRequest;
import com.ironhack.femsa.ecomerce_lab08.model.User;
import com.ironhack.femsa.ecomerce_lab08.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "API para Comercio Electrónico - Users", description = "Endpoints para gestionar usuarios")
public class UserController {

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Register user response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/users")
    @Operation(summary = "Registro de usuario",
            description = "Permite registrar un nuevo usuario en el sistema")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return ResponseEntity.ok(userService.registerUser(user));
    }

    /**
     * Login response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/users/login")
    @Operation(summary = "Inicio de sesión",
            description = "Permite a un usuario iniciar sesión en el sistema")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request.getEmail(), request.getPassword()));
    }
}
