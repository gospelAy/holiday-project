package com.example.Election.utils;

import com.example.Election.dto.Request.CandidateRequest;
import com.example.Election.dto.Request.RegisterRequest;
import com.example.Election.dto.Response.CandidateResponse;
import com.example.Election.dto.Response.RegisterResponse;
import com.example.Election.models.Candidate;
import com.example.Election.models.Voter;

public class Mapper {
    public static Voter map(RegisterRequest registerRequest){
        Voter voter = new Voter();
        voter.setGender(registerRequest.getGender());
        voter.setFirstName(registerRequest.getFirstName());
        voter.setLastName(registerRequest.getLastName());
        voter.setState(registerRequest.getState());
        voter.setAge(registerRequest.getAge());
        voter.setUserName(registerRequest.getUserName());
        voter.setVotersPassword(registerRequest.getVotersPassword());
        voter.setVoterEmail(registerRequest.getVoterEmail());
        return voter;
    }
    public static void map(Voter voter, RegisterResponse response){;
        response.setFirstName(voter.getFirstName() + response.getMessage());
    }
    public static Candidate map(CandidateRequest candidateRequest){
        Candidate candidate = new Candidate();
        candidate.setAge(candidateRequest.getAge());
        candidate.setName(candidateRequest.getName());
        candidate.setGender(candidateRequest.getGender());
        candidate.setParty(candidateRequest.getParty());
        return candidate;
    }
    public static void map(Candidate foundCandidate, CandidateResponse response){
        response.setAge(foundCandidate.getAge());
        response.setGender(foundCandidate.getGender());
        response.setName(foundCandidate.getName());
        response.setParty(foundCandidate.getParty());
    }

}


