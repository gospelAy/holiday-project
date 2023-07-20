package com.example.Election.Service;

import com.example.Election.dto.Request.RegisterRequest;
import com.example.Election.dto.Response.RegisterResponse;
import com.example.Election.models.Party;
import com.example.Election.models.Voter;

import java.util.List;
import java.util.Optional;

public interface VoterService {
    RegisterResponse voterRegistration(RegisterRequest registerRequest);
    Optional<Voter> findById(Long id);
    void voteForCandidate(Long voterId, Party selectedCandidate);
    boolean deleteVoter(Long id);
    List<Voter> getAllVoter();
//    void sendRegistrationConfirmationEmail(String recipientEmail);
}
