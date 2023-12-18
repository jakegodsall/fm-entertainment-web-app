package com.jakegodsall.fmentertainmentwebappbackend.repository.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
