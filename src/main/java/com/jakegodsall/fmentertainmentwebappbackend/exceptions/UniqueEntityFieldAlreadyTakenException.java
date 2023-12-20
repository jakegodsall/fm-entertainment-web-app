package com.jakegodsall.fmentertainmentwebappbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniqueEntityFieldAlreadyTakenException extends RuntimeException {
    private String field;
    private String username;

    public UniqueEntityFieldAlreadyTakenException(String field, String username) {
        super(String.format("%s %s is already taken", field, username));
        this.field = field;
        this.username = username;
    }
}
