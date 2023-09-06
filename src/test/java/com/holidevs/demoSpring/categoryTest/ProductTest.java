package com.holidevs.demoSpring.categoryTest;

import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.models.Product;
import com.holidevs.demoSpring.repositories.CategoryRepository;
import com.holidevs.demoSpring.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class ProductTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @BeforeEach
    void setup(){

        Category shoes = new Category("shoes");
        Category books = new Category("books");
        Category electronics = new Category("electronics");

        categoryRepository.save(shoes);
        categoryRepository.save(books);
        categoryRepository.save(electronics);

        Product runningShoes = new Product("Running Shoes", "High-performance running shoes with cushioned soles.", 50.0, 129.99, "In Stock", shoes);
        Product casualSneakers = new Product("Casual Sneakers", "Stylish and comfortable sneakers for everyday wear.", 60.0, 79.99, "In Stock", shoes);
        Product hikingBoots = new Product("Hiking Boots", "Durable hiking boots for outdoor adventures.", 40.0, 149.99, "In Stock", shoes);
        Product basketballShoes = new Product("Basketball Shoes", "Specialized basketball shoes for optimal performance.", 30.0, 109.99, "In Stock", shoes);
        Product dressShoes = new Product("Dress Shoes", "Elegant dress shoes for formal occasions.", 25.0, 89.99, "In Stock", shoes);

        Product fictionNovel = new Product("Fiction Novel", "An engaging fiction novel by a bestselling author.", 100.0, 15.99, "In Stock", books);
        Product cookbook = new Product("Cookbook", "A cookbook featuring a variety of delicious recipes.", 90.0, 19.99, "In Stock", books);
        Product selfHelpBook = new Product("Self-Help Book", "A self-help book offering valuable life advice.", 80.0, 12.99, "In Stock", books);
        Product scienceTextbook = new Product("Science Textbook", "A comprehensive science textbook for students.", 120.0, 39.99, "In Stock", books);
        Product travelGuide = new Product("Travel Guide", "A travel guidebook with tips for your next adventure.", 70.0, 9.99, "In Stock", books);

        Product smartphone = new Product("Smartphone", "The latest smartphone with advanced features.", 30.0, 699.99, "In Stock", electronics);
        Product laptop = new Product("Laptop", "A powerful laptop for work and entertainment.", 25.0, 999.99, "In Stock", electronics);
        Product headphones = new Product("Headphones", "High-quality headphones for immersive audio.", 50.0, 149.99, "In Stock", electronics);
        Product smartTV = new Product("Smart TV", "A smart TV with 4K resolution and streaming capabilities.", 20.0, 499.99, "In Stock", electronics);
        Product gamingConsole = new Product("Gaming Console", "The latest gaming console for gamers.", 15.0, 399.99, "In Stock", electronics);

        productRepository.saveAll(Arrays.asList(
                runningShoes, casualSneakers, hikingBoots, basketballShoes, dressShoes,
                fictionNovel, cookbook, selfHelpBook, scienceTextbook, travelGuide,
                smartphone, laptop, headphones, smartTV, gamingConsole
        ));

    }


    @Test
    void testProductName() {
        Product product = productRepository.findByName("Running Shoes");
        assertNotNull(product);
        assertEquals("Running Shoes", product.getName());
    }

    @Test
    void testProductDescription() {
        Product product = productRepository.findByName("Casual Sneakers");
        assertNotNull(product);
        assertEquals("Stylish and comfortable sneakers for everyday wear.", product.getDescription());
    }

    @Test
    void testProductStock() {
        Product product = productRepository.findByName("Hiking Boots");
        assertNotNull(product);
        assertEquals(40.0, product.getStock());
    }

    @Test
    void testProductPrice() {
        Product product = productRepository.findByName("Basketball Shoes");
        assertNotNull(product);
        assertEquals(109.99, product.getPrice());
    }

    @Test
    void testProductStatus() {
        Product product = productRepository.findByName("Dress Shoes");
        assertNotNull(product);
        assertEquals("In Stock", product.getStatus());
    }

    @Test
    void testProductCategory() {
        Product product = productRepository.findByName("Fiction Novel");
        assertNotNull(product);
        Category category = product.getCategory();
        assertNotNull(category);
        assertEquals("books", category.getName());
    }


    @AfterEach
    void teardown(){productRepository.deleteAll();}
}
