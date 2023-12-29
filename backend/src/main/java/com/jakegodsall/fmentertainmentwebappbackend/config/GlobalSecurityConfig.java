package com.jakegodsall.fmentertainmentwebappbackend.config;

import com.jakegodsall.fmentertainmentwebappbackend.repository.security.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@AllArgsConstructor
@Configuration
public class GlobalSecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {



        return http
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/api/**")
                            .authenticated();
                })
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .userDetailsService(jpaUserDetailsService)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
