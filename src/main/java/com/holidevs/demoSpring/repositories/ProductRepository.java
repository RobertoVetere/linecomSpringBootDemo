package com.holidevs.demoSpring.repositories;

import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);

    Product findByName(String running_shoes);
}
