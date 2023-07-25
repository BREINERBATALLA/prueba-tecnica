package com.nexsys.prueba.infraestructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorResponseApiException extends ResponseStatusException {

    public ErrorResponseApiException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR ,message);
    }
}
