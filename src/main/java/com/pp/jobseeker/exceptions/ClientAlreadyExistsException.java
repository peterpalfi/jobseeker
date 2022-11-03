package com.pp.jobseeker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ClientAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClientAlreadyExistsException(String message) {
        super(message);
    }
}
