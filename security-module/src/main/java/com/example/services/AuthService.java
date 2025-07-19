package com.example.services;

import com.example.entity.UserCredential;
import com.example.repositories.UserCredentialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserCredentialRepo userCredentialRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public String save(UserCredential userCredential) {
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userCredentialRepo.save(userCredential);
        return "User is saved";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
