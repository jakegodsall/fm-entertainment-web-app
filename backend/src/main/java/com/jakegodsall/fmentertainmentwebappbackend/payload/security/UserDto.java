package com.jakegodsall.fmentertainmentwebappbackend.payload.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private Long id;

    private Long version;

    @Size(
            min = 10,
            max = 100,
            message = "Username must be between 10 and 100 characters"
    )
    @NotNull(message = "Username is mandatory")
    private String username;

    @Size(
            min = 10,
            max = 30,
            message = "Password must be between 10 and 30 characters"
    )
    @Pattern(
            regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}",
            message = "Password must contain at least one digit, one lowercase, one uppercase letter, and one special character"
    )
    @NotNull(message = "Password is mandatory")
    private String password;

    @Email(message = "Email must be valid")
    @Size(max = 100)
    @NotNull(message = "email is mandatory")
    private String email;

    @Singular
    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return username;
    }
}
