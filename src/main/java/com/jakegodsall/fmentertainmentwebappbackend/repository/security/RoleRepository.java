package com.jakegodsall.fmentertainmentwebappbackend.repository.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
