package com.jakegodsall.fmentertainmentwebappbackend.repository.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
