package com.holidevs.demoSpring.controllers;

import com.holidevs.demoSpring.dto.ProductDto;
import com.holidevs.demoSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
