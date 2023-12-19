package com.jakegodsall.fmentertainmentwebappbackend.bootstrap.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Authority;
import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Role;
import com.jakegodsall.fmentertainmentwebappbackend.entity.security.User;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.AuthorityRepository;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.RoleRepository;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BootstrapSecurity implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            bootstrapAuthoritiesAndRoles();
        }
    }

    private void bootstrapAuthoritiesAndRoles() {
        // Create authorities for User entity
        Authority getUser = Authority.builder().permission("GET_USER").build();
        Authority createUser = Authority.builder().permission("CREATE_USER").build();
        Authority updateUser = Authority.builder().permission("UPDATE_USER").build();
        Authority deleteUser = Authority.builder().permission("DELETE_USER").build();

        // Create admin role
        Role adminRole = Role.builder()
                .name("ADMIN")
                .authority(getUser)
                .authority(createUser)
                .authority(updateUser)
                .authority(deleteUser)
                .build();

        // Create admin user with ADMIN role
        User adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin_password"))
                .email("admin@example.com")
                .role(adminRole)
                .build();

        userRepository.save(adminUser);
    }
}
