package com.nexsys.prueba.domain.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

public record ProductCreateRequestDto(@NotEmpty(message = "name can't be empty") String name,
                                      @Positive(message = "priceFinal can't be negative") Integer priceFinal,
                                      @NotEmpty(message = "description can't be empty") String description,
                                      Long categoryId,
                                      @URL(message = "imageUrl must be a valid url") String imageUrl) { }
