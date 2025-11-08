package com.example.services.assymetrics;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.Date;
import java.util.Map;

@Service
public class JWTProducer {

    private final PrivateKey privateKey;

    public JWTProducer(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
            .signWith(privateKey)
            .compact();
    }
}
