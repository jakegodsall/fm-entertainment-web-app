package com.jakegodsall.fmentertainmentwebappbackend.entity.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
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
@Table(name = "role")
public class Role extends BaseEntity {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER
    )
    @JoinTable(name = "role_authority",
               joinColumns = @JoinColumn(name = "role_id"),
               inverseJoinColumns = @JoinColumn(name = "authority_id"))
    Set<Authority> authorities = new HashSet<>();

}
