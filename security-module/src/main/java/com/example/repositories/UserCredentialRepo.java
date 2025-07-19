package com.example.repositories;

import com.example.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepo extends JpaRepository<UserCredential, Long> {
    UserCredential findByUsername(String username);
}
