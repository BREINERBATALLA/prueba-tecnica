package com.nexsys.prueba.infraestructure.controllers;

import com.nexsys.prueba.application.services.CategoryService;
import com.nexsys.prueba.domain.dtos.response.CategoryGetAllResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/nexsys/v1")
@Tag(name = "Category")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(
            description = "Get endpoint for category",
            summary = "Get all categories",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Getting error from external Api",
                            responseCode = "500"
                    )
            }

    )
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryGetAllResponseDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
