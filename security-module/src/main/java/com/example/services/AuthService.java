package com.example.services;

import com.example.entity.UserCredential;
import com.example.repositories.UserCredentialRepo;
import com.example.services.assymetrics.JWTProducer;
import com.example.services.assymetrics.JWTValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserCredentialRepo userCredentialRepo;
    private final PasswordEncoder passwordEncoder;
//    private final JWTService jwtService;
    private final JWTValidator jwtValidator;
    private final JWTProducer jwtProducer;


    public String save(UserCredential userCredential) {
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userCredentialRepo.save(userCredential);
        return "User is saved";
    }

    public String generateToken(String username) {
        return jwtProducer.createToken(new HashMap<>(), username);
    }

    public boolean validateToken(String token) {
        return jwtValidator.validateToken(token);
    }

}
