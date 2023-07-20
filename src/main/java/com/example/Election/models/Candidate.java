package com.example.Election.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue
    private Long candidateId;
    private String name;
    private int age;
    private String gender;
    @Enumerated(EnumType.STRING)
    private Party party;
}
