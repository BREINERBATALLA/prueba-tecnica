package com.nexsys.prueba.domain.dtos.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
public record ExceptionResponseDto(List<String> messages, HttpStatus status) {}
