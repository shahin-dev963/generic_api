package com.shahin.genericrestapi.controller;

import com.shahin.genericrestapi.dto.ProductDto;
import com.shahin.genericrestapi.dto.Response;
import com.shahin.genericrestapi.service.ProductService;
import com.shahin.genericrestapi.util.ResponseBuilder;
import com.shahin.genericrestapi.util.UrlConstraint;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(UrlConstraint.ProductManagement.ROOT)
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(UrlConstraint.ProductManagement.CREATE)
    public Response create(@Valid @RequestBody ProductDto productDto, BindingResult result){
        if (result.hasErrors()){
            return ResponseBuilder.getFailureResponse(result,"Bean Binding error");
        }

        return productService.save(productDto);
    }

    @PutMapping(UrlConstraint.ProductManagement.UPDATE)
    public Response update(@PathVariable("id") Long id, @Valid @RequestBody ProductDto productDto, BindingResult result){
        if (result.hasErrors()){
            return ResponseBuilder.getFailureResponse(result,"Bean Binding error");
        }

        return productService.update(id,productDto);
    }

    @DeleteMapping(UrlConstraint.ProductManagement.DELETE)
    public Response delete(@PathVariable("id") Long id){
        return productService.delete(id);
    }

    @GetMapping(UrlConstraint.ProductManagement.GET)
    public Response get(@PathVariable("id") Long id){
        return productService.get(id);
    }

    @GetMapping(UrlConstraint.ProductManagement.GET_ALL)
    public Response getAll(){
        return productService.getAll();
    }

}
