package com.jakegodsall.fmentertainmentwebappbackend.entity.security;


import com.jakegodsall.fmentertainmentwebappbackend.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
public class User extends BaseEntity {

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

    @Singular
    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles = new HashSet<>();

    @Transient
    private Set<Authority> authorities = new HashSet<>();

    @Override
    public String toString() {
        return username;
    }
}
