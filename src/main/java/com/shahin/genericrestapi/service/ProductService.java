package com.shahin.genericrestapi.service;

import com.shahin.genericrestapi.dto.ProductDto;
import com.shahin.genericrestapi.dto.Response;

public interface ProductService {

    Response save(ProductDto productDto);
    Response update(Long id, ProductDto productDto);
    Response delete(Long id);
    Response get(Long id);
    Response getAll();

}
