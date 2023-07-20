package com.example.Election.dto.Response;

import lombok.Data;

@Data
public class RegisterResponse {
    private String message;
    private String firstName;
    private String votersPassword;
}
