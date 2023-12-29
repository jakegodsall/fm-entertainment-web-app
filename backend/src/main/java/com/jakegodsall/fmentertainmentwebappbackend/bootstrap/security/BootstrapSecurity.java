package com.jakegodsall.fmentertainmentwebappbackend.bootstrap.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Authority;
import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Role;
import com.jakegodsall.fmentertainmentwebappbackend.entity.security.User;
import com.jakegodsall.fmentertainmentwebappbackend.exceptions.ResourceNotFoundByNameException;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.AuthorityRepository;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.RoleRepository;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
        bootstrapUserAuthoritiesAndRoles();
        bootstrapAdminAuthoritiesAndRoles();
        bootstrapAdminUser();
    }

    private void bootstrapUserAuthoritiesAndRoles() {
        // Create authorities for the User entity
        Authority getThisUser = Authority.builder().permission("GET_THIS_USER").build();
        Authority updateThisUser = Authority.builder().permission("UPDATE_THIS_USER").build();
        Authority patchUpdateThisUser = Authority.builder().permission("PATCH_THIS_USER").build();
        Authority deleteThisUser = Authority.builder().permission("DELETE_THIS_USER").build();

        // Save the USER role to the database
        Optional<Role> existingUserRole = roleRepository.findByName("USER");
        if (existingUserRole.isEmpty()) {
            // Create USER role
            Role userRole = Role.builder()
                    .name("USER")
                    .authority(getThisUser)
                    .authority(updateThisUser)
                    .authority(patchUpdateThisUser)
                    .authority(deleteThisUser)
                    .build();

            roleRepository.save(userRole);
        }
    }

    private void bootstrapAdminAuthoritiesAndRoles() {
        // Create authorities for User entity
        Authority getUser = Authority.builder().permission("GET_USER").build();
        Authority createUser = Authority.builder().permission("CREATE_USER").build();
        Authority updateUser = Authority.builder().permission("UPDATE_USER").build();
        Authority patchUpdateUser = Authority.builder().permission("PATCH_USER").build();
        Authority deleteUser = Authority.builder().permission("DELETE_USER").build();

        // Save the ADMIN role to the database
        Optional<Role> existingAdminRole = roleRepository.findByName("ADMIN");
        if (existingAdminRole.isEmpty()) {
            // Create ADMIN role
            Role adminRole = Role.builder()
                    .name("ADMIN")
                    .authority(getUser)
                    .authority(createUser)
                    .authority(updateUser)
                    .authority(patchUpdateUser)
                    .authority(deleteUser)
                    .build();

            roleRepository.save(adminRole);
        }
    }

    private void bootstrapAdminUser() {
        // Get the ADMIN role from the database
        Role adminRole = roleRepository.findByName("ADMIN").orElseThrow(
                () -> new ResourceNotFoundByNameException("Role", "name", "ADMIN")
        );

        // Create admin user with ADMIN role
        User adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin_password"))
                .email("admin@example.com")
                .role(adminRole)
                .build();

        if (userRepository.count() == 0) {
            userRepository.save(adminUser);
        }
    }
}
