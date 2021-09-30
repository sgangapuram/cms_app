package com.srione.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//This @ResponseStatus isn't needed when we have a Error handler with @ControllerAdvice and at @RestController level
//There we are already mentioning that HttpStatus.NOT_FOUND.
//This is only needed when no error handler is provided
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
