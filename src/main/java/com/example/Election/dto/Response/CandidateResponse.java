package com.example.Election.dto.Response;

import com.example.Election.models.Party;
import lombok.Data;

@Data
public class CandidateResponse {
    private int candidateId;
    private String name;
    private int age;
    private String gender;
    private Party party;
}
