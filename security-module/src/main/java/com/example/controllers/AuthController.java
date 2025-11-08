package com.example.controllers;

import com.example.dto.AuthRequest;
import com.example.entity.UserCredential;
import com.example.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/v1")
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential userCredential) {
        return authService.save(userCredential);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        //System.out.println("Hello");
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return authService.generateToken(authRequest.getUsername());
        }
        throw new RuntimeException("Invalidate access");
    }

    @GetMapping("/validate")
    public boolean validateToken(@RequestParam("token") String token){
       return authService.validateToken(token);
    }
}
