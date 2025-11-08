package com.example.services.assymetrics;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class JWTValidator {
    private final PublicKey publicKey;

    public JWTValidator(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parse(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
