package com.example.Election.dto.Request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String state;
    private String votersPassword;
    private String UserName;
    private String voterEmail;
}
