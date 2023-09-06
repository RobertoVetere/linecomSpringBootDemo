package com.holidevs.demoSpring;

import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.models.Product;
import com.holidevs.demoSpring.repositories.CategoryRepository;
import com.holidevs.demoSpring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoSpringApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception{

		Category shoes = new Category("shoes");
		Category books = new Category("books");
		Category electronics = new Category("electronics");

		categoryRepository.save(shoes);
		categoryRepository.save(books);
		categoryRepository.save(electronics);

			// Crear y guardar productos de prueba en la base de datos
			createAndSaveProduct("Running Shoes", "High-performance running shoes with cushioned soles.", 50.0, 129.99, "In Stock", shoes);
			createAndSaveProduct("Casual Sneakers", "Stylish and comfortable sneakers for everyday wear.", 60.0, 79.99, "In Stock", shoes);
			createAndSaveProduct("Hiking Boots", "Durable hiking boots for outdoor adventures.", 40.0, 149.99, "In Stock", shoes);
			createAndSaveProduct("Basketball Shoes", "Specialized basketball shoes for optimal performance.", 30.0, 109.99, "In Stock", shoes);
			createAndSaveProduct("Dress Shoes", "Elegant dress shoes for formal occasions.", 25.0, 89.99, "In Stock", shoes);

			createAndSaveProduct("Fiction Novel", "An engaging fiction novel by a bestselling author.", 100.0, 15.99, "In Stock", books);
			createAndSaveProduct("Cookbook", "A cookbook featuring a variety of delicious recipes.", 90.0, 19.99, "In Stock", books);
			createAndSaveProduct("Self-Help Book", "A self-help book offering valuable life advice.", 80.0, 12.99, "In Stock", books);
			createAndSaveProduct("Science Textbook", "A comprehensive science textbook for students.", 120.0, 39.99, "In Stock", books);
			createAndSaveProduct("Travel Guide", "A travel guidebook with tips for your next adventure.", 70.0, 9.99, "In Stock", books);

			createAndSaveProduct("Smartphone", "The latest smartphone with advanced features.", 30.0, 699.99, "In Stock", electronics);
			createAndSaveProduct("Laptop", "A powerful laptop for work and entertainment.", 25.0, 999.99, "In Stock", electronics);
			createAndSaveProduct("Headphones", "High-quality headphones for immersive audio.", 50.0, 149.99, "In Stock", electronics);
			createAndSaveProduct("Smart TV", "A smart TV with 4K resolution and streaming capabilities.", 20.0, 499.99, "In Stock", electronics);
			createAndSaveProduct("Gaming Console", "The latest gaming console for gamers.", 15.0, 399.99, "In Stock", electronics);
		}

		private void createAndSaveProduct(String name, String description, Double stock, Double price, String status, Category category) {
			Product product = new Product();
			product.setName(name);
			product.setDescription(description);
			product.setStock(stock);
			product.setPrice(price);
			product.setStatus(status);

			product.setCategory(category);

			productRepository.save(product);

		}
	}

