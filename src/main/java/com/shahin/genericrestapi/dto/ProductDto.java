package com.shahin.genericrestapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto {
    private Long id;
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotNull(message = "Price is mandatory")
    private Double price;
    private String description;

}
