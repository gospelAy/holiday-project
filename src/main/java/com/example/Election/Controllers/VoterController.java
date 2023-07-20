package com.example.Election.Controllers;

import com.example.Election.Service.VoterService;
import com.example.Election.dto.Request.RegisterRequest;
import com.example.Election.dto.Response.RegisterResponse;
import com.example.Election.models.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class VoterController {
    private VoterService voterService;

    @Autowired
    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }
    @PostMapping("voter/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RegisterResponse> registerVote(@RequestBody RegisterRequest registerRequest){
        return new ResponseEntity<>(voterService.voterRegistration(registerRequest), HttpStatus.CREATED);
    }

    @GetMapping("get")
    public List<Voter> getAllVoter(){
      return voterService.getAllVoter();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deletionStatus = voterService.deleteVoter(id);
        if (deletionStatus) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
