package com.nexsys.prueba.domain.models;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private Long id;

    private String title;

    private String description;

    private Integer price;

    private Long categoryId;

    private List<String> images;

}
