package com.jakegodsall.fmentertainmentwebappbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundByIdException extends RuntimeException {
    private String resourceName;
    private Long id;

    public ResourceNotFoundByIdException(String resourceName, Long id) {
        super(String.format("Resource %s with id: %d not found", resourceName, id));
        this.resourceName = resourceName;
        this.id = id;
    }
}
