package com.jakegodsall.fmentertainmentwebappbackend.exceptions;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsernameAlreadyTakenException extends RuntimeException {
    private String username;

    public UsernameAlreadyTakenException(String username) {
        super(String.format("Username %s is already taken", username));
        this.username = username;
    }
}
