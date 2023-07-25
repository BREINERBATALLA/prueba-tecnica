package com.nexsys.prueba.application.services;

import com.nexsys.prueba.application.mappers.ProductMapper;
import com.nexsys.prueba.domain.dtos.request.ProductCreateRequestDto;
import com.nexsys.prueba.domain.dtos.response.ProductCreateResponseDto;
import com.nexsys.prueba.domain.dtos.response.ProductGetAllResponseDto;
import com.nexsys.prueba.domain.models.Product;
import com.nexsys.prueba.domain.usecases.ProductUseCase;
import com.nexsys.prueba.infraestructure.exceptions.ErrorResponseApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements ProductUseCase {

    private final RestTemplate restTemplate;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;
    @Value("${spring.external.base-url}")
    private String baseUrl;

    /**
     * @return Products' list
     */
    public List<ProductGetAllResponseDto> getAllProducts() {
        ResponseEntity<Product[]> responsePlatziApi = restTemplate.exchange(baseUrl+"/products", HttpMethod.GET, null,  Product[].class);

        if ( responsePlatziApi.getStatusCode().is2xxSuccessful() ) {
            return Arrays.stream(responsePlatziApi.getBody()).map(productMapper::toProductResponseDto).toList();
        } else {
            throw new ErrorResponseApiException("Something went wrong with the external api");
        }
    }

    /**
     * @param productCreateRequestDto
     * @return ProductCreateResponseDto
     */
    public ProductCreateResponseDto createProduct(ProductCreateRequestDto productCreateRequestDto) {
        Product newProduct = productMapper.toProduct(productCreateRequestDto);
        newProduct.setImages(List.of(productCreateRequestDto.imageUrl()));
        newProduct.setCategoryId(categoryService.getIdCategory());
        ResponseEntity<Product> responsePlatziApi = restTemplate.postForEntity(baseUrl+"/products", newProduct, Product.class);

        if ( responsePlatziApi.getStatusCode().is2xxSuccessful() ) {
            return productMapper.toProductCreateResponseDto(responsePlatziApi.getBody());
        } else{
            throw new ErrorResponseApiException("Something went wrong with the external api");
        }
    }


}
