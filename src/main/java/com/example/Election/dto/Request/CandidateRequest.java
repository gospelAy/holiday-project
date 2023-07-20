package com.example.Election.dto.Request;

import com.example.Election.models.Party;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CandidateRequest {
    private String name;
    private int age;
    private String gender;
    @Enumerated(EnumType.STRING)
    private Party party;
}
