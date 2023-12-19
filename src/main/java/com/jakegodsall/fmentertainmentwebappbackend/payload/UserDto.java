package com.jakegodsall.fmentertainmentwebappbackend.payload;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Role;
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

    private String username;

    private String password;

    private String email;

    @Singular
    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return username;
    }
}
