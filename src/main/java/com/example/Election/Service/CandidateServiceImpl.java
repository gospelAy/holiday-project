package com.example.Election.Service;

import com.example.Election.dto.Request.CandidateRequest;
import com.example.Election.dto.Response.CandidateResponse;
import com.example.Election.models.Candidate;
import com.example.Election.models.Party;
import com.example.Election.repo.CandidateRepository;
import com.example.Election.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService{
    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    Candidate registerCandidate;
    @Override
    public CandidateResponse createCandidate(CandidateRequest candidateRequest) {
        registerCandidate = Mapper.map(candidateRequest);
        CandidateResponse candidateResponse = new CandidateResponse();
        Candidate candidate = candidateRepository.save(registerCandidate);
        Mapper.map(candidate, candidateResponse);
        return candidateResponse;
    }


    @Override
    public Optional<Candidate> findById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate findByParty(Party party) {
        return candidateRepository.findByParty(party);
    }
}
