package com.nexsys.prueba.infraestructure.controllers;

import com.nexsys.prueba.application.services.ProductService;
import com.nexsys.prueba.domain.dtos.request.ProductCreateRequestDto;
import com.nexsys.prueba.domain.dtos.response.ProductCreateResponseDto;
import com.nexsys.prueba.domain.dtos.response.ProductGetAllResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/nexsys/v1")
@Tag(name = "Product")
public class ProductController {

    private final ProductService productService;

    @Operation(
            description = "Get endpoint for product",
            summary = "Get all products",
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
    @GetMapping("/products")
    public ResponseEntity<List<ProductGetAllResponseDto>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(
            description = "Post endpoint for product",
            summary = "Create a new product",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Getting error from external Api",
                            responseCode = "500"
                    )
            }

    )
    @PostMapping("/categories")
    public ResponseEntity<ProductCreateResponseDto> createProduct(@Valid @RequestBody ProductCreateRequestDto productCreateRequestDto){
        return  new ResponseEntity<>(productService.createProduct(productCreateRequestDto), HttpStatus.CREATED);
    }
}
