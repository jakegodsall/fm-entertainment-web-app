package com.jakegodsall.fmentertainmentwebappbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundByNameException extends RuntimeException {
    private String resourceName;
    private String key;
    private String value;

    public ResourceNotFoundByNameException(
            String resourceName,
            String key,
            String value
    ) {
        super(String.format("The instance of %s with %s = %s was not found",
                resourceName, key, value));
        this.resourceName = resourceName;
        this.key = key;
        this.value = value;
    }
}
