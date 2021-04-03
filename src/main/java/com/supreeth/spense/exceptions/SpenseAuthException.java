package com.supreeth.spense.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class SpenseAuthException extends RuntimeException{

    public SpenseAuthException(String message) {
        super(message);
    }
}
