package com.holidevs.demoSpring.repositories;

import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);

    Product findByName(String running_shoes);

    Optional<Product> findById(Long id);

    Product save(Product product);

    void delete(Product product);

}
