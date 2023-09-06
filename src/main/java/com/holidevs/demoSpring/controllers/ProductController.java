package com.holidevs.demoSpring.controllers;

import com.holidevs.demoSpring.dto.ProductDto;
import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.models.Product;
import com.holidevs.demoSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> listAllProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("/find-by-category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findByCategory(@PathVariable Category category) {
        return productService.findByCategory(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@PathVariable Long id){
        return productService.removeProduct(id);
    }
}
