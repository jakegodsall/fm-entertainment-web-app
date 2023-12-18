package com.jakegodsall.fmentertainmentwebappbackend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
public class User extends BaseUser {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, unique = true, nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @Size(max = 100)
    @NotNull
    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Builder.Default
    private Boolean isAccountNonExpired = true;

    @Builder.Default
    private Boolean isAccountNonLocked = true;

    @Builder.Default
    private Boolean isCredentialNonExpired = true;

    @Builder.Default
    private Boolean isEnabled = true;

}
