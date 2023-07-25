package com.nexsys.prueba.infraestructure.exceptions;

import com.nexsys.prueba.domain.dtos.response.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ExceptionResponseDto> errorResponseApi(ResponseStatusException ex) {
        ExceptionResponseDto response = ExceptionResponseDto.builder()
                .messages(List.of(ex.getMessage()))
                .status(HttpStatus.valueOf(ex.getStatusCode().value()))
                .build();

        return new ResponseEntity<>(response, response.status());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleInvalidArgument(MethodArgumentNotValidException ex) {
        List<String> defaultMessages = null;
        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> defaultMessages.add(fieldError.getDefaultMessage()));
        ExceptionResponseDto response = ExceptionResponseDto.builder()
                .messages(defaultMessages)
                .status((HttpStatus) ex.getStatusCode())
                .build();

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
