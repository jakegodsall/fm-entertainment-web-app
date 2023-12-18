package com.jakegodsall.fmentertainmentwebappbackend.entity.security;

import com.jakegodsall.fmentertainmentwebappbackend.entity.BaseEntity;
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
@Table(name = "authority")
public class Authority extends BaseEntity {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, unique = true, nullable = false)
    private String permission;

    @Override
    public String toString() {
        return permission;
    }
}
