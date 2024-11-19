package com.ironhack.femsa.ecomerce_lab08.dto;

import lombok.Data;
@Data
public class RegisterUserRequest {
    private String username;
    private String email;
    private String password;
}
