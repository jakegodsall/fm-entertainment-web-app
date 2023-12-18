package com.jakegodsall.fmentertainmentwebappbackend.payload;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private String username;

    private String password;

    private String email;

    private Set<Role> roles;

    @Override
    public String toString() {
        return username;
    }
}
