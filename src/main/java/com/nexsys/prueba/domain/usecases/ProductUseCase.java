package com.nexsys.prueba.domain.usecases;

import com.nexsys.prueba.domain.dtos.request.ProductCreateRequestDto;
import com.nexsys.prueba.domain.dtos.response.ProductCreateResponseDto;
import com.nexsys.prueba.domain.dtos.response.ProductGetAllResponseDto;

import java.util.List;

public interface ProductUseCase {
    List<ProductGetAllResponseDto> getAllProducts();

    ProductCreateResponseDto createProduct(ProductCreateRequestDto productCreateRequestDto);
}
