package com.nexsys.prueba.domain.usecases;

import com.nexsys.prueba.domain.dtos.response.CategoryGetAllResponseDto;

import java.util.List;

public interface CategoryUseCase {

    List<CategoryGetAllResponseDto> getAllCategories();

    Long getIdCategory();
}
