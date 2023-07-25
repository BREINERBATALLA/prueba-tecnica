package com.nexsys.prueba.application.services;

import com.nexsys.prueba.application.mappers.CategoryMapper;
import com.nexsys.prueba.domain.dtos.response.CategoryGetAllResponseDto;
import com.nexsys.prueba.domain.models.Category;
import com.nexsys.prueba.domain.usecases.CategoryUseCase;
import com.nexsys.prueba.infraestructure.exceptions.ErrorResponseApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryUseCase {

    private final RestTemplate restTemplate;
    private final CategoryMapper categoryMapper;

    @Value("${spring.external.base-url}")
    private String baseUrl;

    /**
     * @return Categories' list.
     */
    public List<CategoryGetAllResponseDto> getAllCategories() {

        ResponseEntity<Category[]> responsePlatziApi = restTemplate.exchange(
                baseUrl+"/categories", HttpMethod.GET, null, Category[].class
        );

        if ( responsePlatziApi.getStatusCode().is2xxSuccessful() ) {
            return Arrays.stream(responsePlatziApi.getBody()).map(categoryMapper::toCategoryResponseDto).toList();

        } else {
            throw new ErrorResponseApiException("Something went wrong with the external api");

        }
    }

    /**
     * @return Random existing id of category.
     */
    public Long getIdCategory() {
        List<CategoryGetAllResponseDto>  listCategories = getAllCategories();
        Random random = new Random();
        int index  = random.nextInt(listCategories.size()-1);

        return listCategories.get(index).cid();

    }
}
