package com.holidevs.demoSpring.services.interfaces;

import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    public List<Product> listAllProducts();
    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product removeProduct(Product product);
    public List<Product> findByCategory(Category category);
    public Optional<Product> updateStock(Long id, Double quantity);
}
