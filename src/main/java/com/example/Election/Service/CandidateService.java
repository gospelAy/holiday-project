package com.example.Election.Service;

import com.example.Election.dto.Request.CandidateRequest;
import com.example.Election.dto.Response.CandidateResponse;
import com.example.Election.models.Candidate;
import com.example.Election.models.Party;

import java.util.Optional;

public interface CandidateService {
    CandidateResponse createCandidate(CandidateRequest candidateRequest);
    Optional<Candidate> findById(Long id);

    Candidate findByParty(Party party);
}
