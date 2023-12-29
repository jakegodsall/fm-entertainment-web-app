package com.jakegodsall.fmentertainmentwebappbackend.entity.security;


import com.jakegodsall.fmentertainmentwebappbackend.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "user",
       uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username", "email"})
       })
public class User extends BaseEntity {

    @Size(
            min = 5,
            max = 100,
            message = "Username must be between 5 and 100 characters"
    )
    @NotNull(message = "Username is mandatory")
    @Column(length = 100, unique = true, nullable = false)
    private String username;

    @NotNull(message = "Password is mandatory")
    @Column(nullable = false)
    private String password;

    @Email(message = "Email must be valid")
    @Size(max = 100)
    @NotNull(message = "email is mandatory")
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
