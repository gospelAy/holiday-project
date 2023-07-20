package com.example.Election.repo;

import com.example.Election.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {

    Voter findByUserName(String userName);
}
