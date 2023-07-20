package com.example.Election.Service;

import com.example.Election.dto.Request.RegisterRequest;
import com.example.Election.dto.Response.RegisterResponse;
import com.example.Election.models.Party;
import com.example.Election.models.Voter;
import com.example.Election.repo.VoterRepository;
import com.example.Election.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterServiceImpl implements VoterService{
    private VoterRepository voterRepository;
    private EmailSenderService senderService;


    @Autowired
    public VoterServiceImpl(VoterRepository voterRepository, EmailSenderService senderService) {
        this.voterRepository = voterRepository;
        this.senderService = senderService;
    }
    Voter registerVoter;

    @Override
    public RegisterResponse voterRegistration(RegisterRequest registerRequest) {
        if (registerRequest.getAge() < 18) {
            throw new IllegalArgumentException("Sorry, you have to be 18 years and above before you can vote.");
        }
        registerVoter = Mapper.map(registerRequest);
        RegisterResponse response = new RegisterResponse();
        Voter voter = voterRepository.save(registerVoter);
        Mapper.map(voter, response);
        senderService.sendEmail(
                registerVoter.getVoterEmail(),
                "Registration Confirmation",
                "Hi " + registerRequest.getFirstName() + ", you have successfully registered. Thank you for being a good citizen."
        );
        response.setMessage("Registration successful. A confirmation email has been sent to your email address.");
        return response;
    }


    @Override
    public Optional<Voter> findById(Long id) {
        return voterRepository.findById(id);
    }

    @Override
    public void voteForCandidate(Long voterId, Party selectedCandidate) {
        Optional<Voter> optionalVoter = voterRepository.findById(voterId);
        if (optionalVoter.isPresent()) {
            Voter voter = optionalVoter.get();
            int currentVoteCount = voter.getVoteCount();
            voter.setVoteCount(currentVoteCount + 1);
            voterRepository.save(voter);
        } else {
            throw new IllegalArgumentException("Voter not found with ID: " + voterId);
        }
    }
    @Override
    public boolean deleteVoter(Long id) {
        voterRepository.deleteById(id);
        return false;
    }

    @Override
    public List<Voter> getAllVoter() {
        return voterRepository.findAll();
    }
//
//    @Override
//    public void sendRegistrationConfirmationEmail(String recipientEmail) {
//        try {
//            JavaMailSenderImpl mailSender = (JavaMailSenderImpl) javaMailSender;
//
//            Properties props = mailSender.getJavaMailProperties();
//            props.put("mail.transport.protocol", "smtp");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.enable", "true");
//
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom("gosple531@gmail.com");
//            helper.setTo(recipientEmail);
//            helper.setSubject("Registration Confirmation");
//            helper.setText("Dear Voter,\n\nThank you for registering. Your registration is successful.");
//
//            mailSender.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }

}
