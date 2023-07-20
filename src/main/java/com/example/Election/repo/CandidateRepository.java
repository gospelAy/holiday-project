package com.example.Election.repo;

import com.example.Election.models.Candidate;
import com.example.Election.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByParty(Party party);
}
