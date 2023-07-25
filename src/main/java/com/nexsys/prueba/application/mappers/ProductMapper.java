package com.nexsys.prueba.application.mappers;

import com.nexsys.prueba.domain.dtos.request.ProductCreateRequestDto;
import com.nexsys.prueba.domain.dtos.response.ProductCreateResponseDto;
import com.nexsys.prueba.domain.dtos.response.ProductGetAllResponseDto;
import com.nexsys.prueba.domain.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id" , target = "pid" ),
            @Mapping(source = "title", target = "name"),
            @Mapping(source = "price", target = "priceFinal")
    })
    ProductGetAllResponseDto toProductResponseDto(Product product);

    @Mappings({
            @Mapping(source = "name" , target = "title" ),
            @Mapping(source = "priceFinal", target = "price"),
            @Mapping(target = "images", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    Product toProduct(ProductCreateRequestDto productCreateRequestDto);

    @Mappings({
            @Mapping(source = "id" , target = "pid" )
    })
    ProductCreateResponseDto toProductCreateResponseDto(Product product);

}
