package com.jakegodsall.fmentertainmentwebappbackend.repository.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
