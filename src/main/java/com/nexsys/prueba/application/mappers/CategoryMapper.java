package com.nexsys.prueba.application.mappers;

import com.nexsys.prueba.domain.dtos.response.CategoryGetAllResponseDto;
import com.nexsys.prueba.domain.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "id" , target = "cid" ),
            @Mapping(source = "name", target = "title"),
    })
    CategoryGetAllResponseDto toCategoryResponseDto(Category category);

}
